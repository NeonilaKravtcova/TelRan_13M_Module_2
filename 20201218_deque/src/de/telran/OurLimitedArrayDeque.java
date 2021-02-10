package de.telran;

public class OurLimitedArrayDeque<T> implements OurDeque<T> {

    private int firstEltId;
    private int size;
    private Object[] source;
    private int capacity;

    public OurLimitedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
    }

    @Override
    public void addFirst(T elt) {
        if (size == capacity){
            throw new DequeOverflowException();
        }
        if (size == 0){
            firstEltId = 0;
        } else if (firstEltId > 0){
            firstEltId--;
        } else {
            firstEltId = capacity - 1;
        }
        size++;
        source[firstEltId] = elt;
    }

    @Override
    public T getFirst() {
        if (size == 0){
            throw new EmptyDequeException();
        }
        return (T) source[firstEltId];
    }

    @Override
    public T removeFirst() {
       if (size == 0){
           throw new EmptyDequeException();
       }
       T res = (T) source[firstEltId];
       source[firstEltId] = null;
       firstEltId = (firstEltId + 1) % capacity;
       size--;
       return res;

    }

    @Override
    public void addLast(T elt) {
        if (size == source.length){
            throw new DequeOverflowException();
        }

        int index = (firstEltId + size) % capacity;
        source[index] = elt;
        size++;
    }

    @Override
    public T getLast() {
        if (size == 0){
            throw new EmptyDequeException();
        }
        int lastIndex = (firstEltId + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public T removeLast() {
        if (size == 0){
            throw new EmptyDequeException();
        }
        int lastIndex = (firstEltId + size - 1) % capacity;
        T res = (T) source[lastIndex];
        source[lastIndex] = null;
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

}
