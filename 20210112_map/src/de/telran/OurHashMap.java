package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * The implementation of OurMap cannot contain null key
 *
 * @param <K>
 * @param <V>
 */

public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

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
            resize();
        }
        Pair<K, V> pair = find(key);

        if (pair != null) {
            System.out.println("Pair != null");
            V res = pair.value;//Сохраняем старое значение, чтобы его вернуть
            pair.value = value;
            return res;
        } else {
            System.out.println("Pair is null");
        }


        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;

        System.out.println("Pair key: " + pair.key + ", pair value: " + pair.value);
        size++;
        return newPair.value;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Pair<K, V>[] newSource = new Pair[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Pair<K, V> currentPair = source[i];
            while (currentPair != null) {
                int index = hash(currentPair.key) % newCapacity;
                newSource[index].next = newSource[index];
                //currentPair.next = newSource[index];
                newSource[index] = currentPair;
                currentPair = currentPair.next;
            }
        }

        //14.01.2021
/*        for (Pair<K, V> cell : source){
            Pair<K, V> currentPair = cell;
            while (currentPair != null){
                int newIndex = hash(currentPair.key) % newCapacity;
                currentPair.next = newSource[newIndex];
                newSource[newIndex] = currentPair;
                currentPair = currentPair.next;
            }
        }*/

        source = newSource;
    }

    private Pair<K, V> find(K key) {
        //int index = hash(key) % capacity;
        int index = Math.abs(key.hashCode() % capacity);
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

        //assert pairToRemove != null;
        V res = pairToRemove.value;

        if (size == 0 || res == null) {
            return res;
        }
        if (pairToRemove.next == null) {
            pairToRemove = null;
        }

        int index = hash(key) % capacity;
        Pair<K, V> currentPair = source[index];

        while (currentPair != null) {
            if (currentPair.equals(pairToRemove)){
                currentPair = pairToRemove.next;
                pairToRemove = null;
            } else {
                currentPair = currentPair.next;
            }
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
