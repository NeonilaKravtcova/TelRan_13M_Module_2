package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * The implementation of OurMap cannot contain null key
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
    public OurHashMap(){
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    //Это необязательный метод, мы его написали как донастройку hashCode
    static int hash(Object key){
        return Math.abs(key.hashCode());//эта функция не очень хорошая, так как все значения этой функции
                            // могут находиться в довольно низком диапазоне
    }

    public OurHashMap(double loadFactor) {
        this();//Конструкторы можно вызывать друг из друга
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity){
            resize();
        }
        Pair<K, V> pair = find(key);

        if (pair != null) {
            //V res = pair.value;//Берем старое значение
            pair.value = value;
            //size++;
            //return res;
            return pair.value;
        }

        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;
        size++;
        return newPair.value;
    }

    private void resize(){
        int newCapacity = capacity * 2;
        Pair<K, V>[] newSource = new Pair[newCapacity];

        for (Pair<K, V> pair : source) {
            if (pair != null) {
                int index = hash(pair.key) % newCapacity;
                newSource[index] = pair;
            }
        }
        source = newSource;
    }

    private Pair<K, V> find(K key){
        //int index = hash(key) % capacity;
        int index = Math.abs(key.hashCode() % capacity);
        Pair<K, V> current = source[index];
        while (current != null){
            if (key.equals(current.key)){
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        if (source.length == 0) {
            throw new NullPointerException();
        }
        Pair<K, V> pair = find(key);
        if (pair == null) {
            throw new NullPointerException();
        } else return pair.value;
    }

    @Override
    public V remove(K key) {
        if (source.length == 0) {
            throw new NullPointerException();
        }
        Pair<K, V> pairToDelete = find(key);

        if (pairToDelete == null) {
            throw new NullPointerException();
        }

        if (pairToDelete.next == null){
            pairToDelete = null;
        }

        //int index = Math.abs(key.hashCode() % capacity);

        for (Pair<K, V> pair : source){

            if (pair.next.equals(pairToDelete)){
                Pair<K, V> prev = pair;
                prev.next = pair.next;
                pair = null;
            } else if (pair.equals(pairToDelete)) {
                pair = null;
            }
        }

/*        while (pairToDelete != null){
            if (source[index].key.equals(key)){
                Pair<K, V> prev =
                Pair<K, V> next = pairToDelete.next;

            }
        }*/

        size--;
        return pairToDelete.value;
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

    public static class Pair<K, V>{
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
