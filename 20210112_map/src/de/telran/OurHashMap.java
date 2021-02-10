package de.telran;

import java.util.Iterator;

/**
 * The implementation of OurMap cannot contain null key
 *
 * @param <K>
 * @param <V>
 */

public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 4;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;

    //Пустой конструктор
    public OurHashMap() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    //Это необязательный метод, мы его написали как донастройку hashCode
    static int hash(Object key) {
        return Math.abs(key.hashCode());//эта функция не очень хорошая, так как все значения этой функции
        // могут находиться в довольно низком диапазоне
    }

    public OurHashMap(double loadFactor) {
        this();//Конструкторы можно вызывать друг из друга
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity) {
            System.out.println("Запуск resize()");
            resize();
        }
        Pair<K, V> pair = find(key);

        if (pair != null) {
            V res = pair.value;//Сохраняем старое значение, чтобы его вернуть
            pair.value = value;
            return res;
        }

        int index = hash(key) % capacity;
        System.out.println("index = " + index);
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;

        size++;
        return null;
    }

/*    private void resize() {
        capacity = capacity * 2;
        Pair<K, V>[] newSource = new Pair[capacity];

        for (int i = 0; i < capacity / 2; i++) {
            Pair<K, V> currentPair = source[i];

            while (currentPair != null) {
                System.out.println("CurrentPair != null");
                int index = hash(currentPair.key) % capacity;
                System.out.println("New index " + index);
                Pair<K, V> next = newSource[index];

                newSource[index] = currentPair;
                newSource[index].next = next;
                //currentPair = next;
                currentPair = currentPair.next;


            }
        }*/


/*        for (Pair<K, V> pair : source) {
            if (pair != null) {
                int index = hash(pair.key) % newCapacity;
                newSource[index] = pair;
            }
        }*/

        //15.01.2021
        private void resize() {
            capacity = capacity * 2;
            Pair<K, V>[] newSource = new Pair[capacity];
            for (Pair<K, V> cell : source) {
                Pair<K, V> currentPair = cell;
                while (currentPair != null) {
                    System.out.println("CurrentPair != null");
                    int newIndex = hash(currentPair.key) % capacity;
                    System.out.println("New index " + newIndex);
                    Pair<K, V> next = currentPair.next;

                    currentPair.next = newSource[newIndex];
                    newSource[newIndex] = currentPair;

                    currentPair = next;
                }
            }

        source = newSource;
    }

    private Pair<K, V> find(K key) {
        int index = hash(key) % capacity;
        //int index = Math.abs(key.hashCode() % capacity);
        Pair<K, V> current = source[index];
        while (current != null) {
            if (key.equals(current.key)) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = find(key);
        if (size == 0 || pair == null) {
            return null;
        } else return pair.value;
    }

    @Override
    public V remove(K key) {

        Pair<K, V> pairToRemove = find(key);

        assert pairToRemove != null;
        V res = pairToRemove.value;

        int index = hash(key) % capacity;

        Pair<K, V> currentPair = source[index];

        if (source[index].key.equals(key)){
            source[index] = source[index].next;
        } else {
            currentPair = currentPair.next;
            while (!currentPair.key.equals(key)){
                currentPair = currentPair.next;
            }
            currentPair.value = null;
        }
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        return null;
    }

    private class KeyIterator implements Iterator<K>{
        int index;
        int position;
        Pair<K, V> currentPair;

        KeyIterator(){
            if (size == 0){

            }
            int i = 0;
            while (source[i] == null){
                i++;
            }

            currentPair = source[i];
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public K next() {
            if (position >= size){
                throw new IndexOutOfBoundsException();
            }

            K res = currentPair.key;

            if (currentPair.next != null){
                currentPair = currentPair.next;
            }

            return null;
        }
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    public static class Pair<K, V> {
        K key;
        V value;
        private Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //Чтобы быстрее было делать rehash, можно добавить hash

/*
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Pair<K, V> getNext() {
            return next;
        }*/
    }
}
