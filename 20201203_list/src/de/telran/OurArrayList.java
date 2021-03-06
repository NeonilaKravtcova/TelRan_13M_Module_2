package de.telran;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurArrayList<Type> implements OurList<Type>{

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(Type element) {
        if (size == source.length)
            increaseCapacity();

//      source[size++] = element;
        source[size] = element;
        size++;
    }

    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public Type get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (Type) source[index];
    }

    @Override
    public void set(int index, Type value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }


    @Override
    public Type removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Type res = (Type) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        //Если метод оставить в данном виде, то предполагается утечка памяти
        //Мы не удаляем ссылку в последней ячейке по адресу size-1
        source[size-1] =null;
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        source = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean remove(Type obj){
        if (obj == null){
            for (int i = 0; i < size; i++) {
                if (source[i] == null){
                    removeById(i);
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i])){
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Type obj){
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null)
                    return true;
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Type> forwardIterator() {
        //Iterator<Type> iterator = new ForwardIterator();
        //return iterator;
        return new ForwardIterator();
    }

    @Override
    public Iterator<Type> backwardIterator() {
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator<Type> {

        int currentIndex = size - 1;

        @Override
        public boolean hasNext(){
            return currentIndex >= 0;
        }

        @Override
        public Type next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            } else return (Type) source[currentIndex--];
        }

    }

    private class ForwardIterator implements Iterator<Type> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return this.currentIndex < size;
        }

        @Override
        public Type next() {
/*            if (currentIndex >= size){
                throw new IndexOutOfBoundsException();}*/

            if (!hasNext())
                throw new NoSuchElementException();

/*            Type res = (Type) source[currentIndex];
            currentIndex++;
            return res;*/
            return (Type) source[currentIndex++];
        }
    }


}
