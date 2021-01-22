package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public class OurTreeMap<K, V> implements OurMap<K, V> {

    private static class Node<K, V> {
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;//Заведём для простоты, хотя лучше избегать лишних ссылок по возможности

        K key;
        V value;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private final Comparator<K> keyComparator;
    private Node<K, V> root;//Изначально root = 0
    private int size;

    //Нам нужно два конструктора на дерево

    //1-ый случай - когда у ключей нет естественного порядка
    public OurTreeMap(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    //2-ой случай - когда ключи упорядочены и можно не передавать компаратор, то есть компаратор остаётся null,
    // но тогда откуда его взять?

    /**
     * if we use this constructor in the client code, that means that the keys are Comparable
     */
    public OurTreeMap() {
        this.keyComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                Comparable<K> comparableO1 = (Comparable<K>) o1;//Если ключи не Comparable, то будет выкинут ClassCastException
                return comparableO1.compareTo(o2);
            }
        };
    }


    @Override
    public V put(K key, V value) {
/*        if (root == null) {
            root = new Node<>(key, value, null);
            return null;//Возвращаем null, так как до добавления элемента дерево было пустым
        }*/

        if (key == null){
            throw new NullPointerException();
        }

        Node<K, V> current = root;
        Node<K, V> parent = null;

        int resultOfComparison = 0;

        while (current != null) {
            parent = current;

            resultOfComparison = keyComparator.compare(current.key, key);

            if (resultOfComparison < 0) {
                current = current.right;
            } else if (resultOfComparison > 0) {
                current = current.left;
            } else {
                V res = current.value;
                current.value = value;
                return res;
            }
        }

        Node<K, V> newNode = new Node<>(key, value, parent);

        if (resultOfComparison < 0) {
            parent.right = newNode;
        } else if (resultOfComparison > 0) {
            parent.left = newNode;
        } else {
            root = newNode;
        }

        size++;
        return null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node == null ? null : node.value;
    }

    private Node<K, V> findNode(K key){
        Node<K, V> current = root;

        int resultOfComparison = 0;

        while (current != null) {

            resultOfComparison = keyComparator.compare(current.key, key);

            if (resultOfComparison < 0) {
                current = current.right;
            } else if (resultOfComparison > 0) {
                current = current.left;
            } else {
                V res = current.value;
                return current;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        Node<K, V> nodeToRemove = findNode(key);

        if (nodeToRemove == null){
            return null;
        }

        size--;

        if (nodeToRemove.left != null && nodeToRemove.right != null){
            return junctionRemove(nodeToRemove);
        }

        return linearRemove(nodeToRemove);
    }

    private V linearRemove(Node<K, V> nodeToRemove){

        if (nodeToRemove == null){
            return null;
        }

        V res = nodeToRemove.value;

/*        if (nodeToRemove == root) {
            Node<K, V> next = findNext(root);
            Node<K, V> newRoot = new Node<>(next.key, next.value, null);
            newRoot.left = root.left;
            newRoot.right = root.right;
            root.left = null;
            root.right = null;
            root.key = null;
            root.value = null;
            return res;
        }*/

        Node<K, V> parent = nodeToRemove.parent;

        if (nodeToRemove.left == null && nodeToRemove.right != null) {
            if (nodeToRemove == parent.left){
                parent.left = nodeToRemove.right;
            } else {
                parent.right = nodeToRemove.right;
            }
        } else if (nodeToRemove.right == null && nodeToRemove.left != null){
            if (nodeToRemove == parent.left){
                parent.left = nodeToRemove.left;
            } else {
                parent.right = nodeToRemove.left;
            }
        } else {
            if (nodeToRemove == parent.left){
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        nodeToRemove.key = null;
        nodeToRemove.value = null;

        return res;
    }


    private V junctionRemove(Node<K, V> nodeToRemove){

        Node<K, V> nodeNext = findNext(nodeToRemove);

        V oldValue = nodeToRemove.value;

        nodeToRemove.key = nodeNext.key;
        nodeToRemove.value = nodeNext.value;

        linearRemove(nodeNext);
        return oldValue;
    }

    private Node<K, V> findNext(Node<K, V> node){

        if (root == null){
            return null;
        }

        Node<K, V> current = root;
        //Node<K, V> next = root;

        if (current.right != null){
            current = current.right;
            while (current.left != null){
                //next = current;
                current = current.left;
            }
        } else {
            current = current.left;
            while (current.right != null){
                //next = current;
                current = current.right;
            }
        }

        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Iterator<K> keyIterator() {
        return null;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }
}
