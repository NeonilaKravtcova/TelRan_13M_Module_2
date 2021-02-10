package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurLinkedList<T> implements OurList<T> {

    Node<T> first;//null
    Node<T> last;//null
    int size;

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T element;

        public Node(Node<T> next, Node<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }

    public OurLinkedList(Node<T> first, Node<T> last, int size) {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(null, last, element);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 0) {
            return null;
        } else {
            return getNodeByIndex(index).element;
        }
    }

    @Override
    public void set(int index, T value) {
        Node needle = getNodeByIndex(index);
        needle.element = value;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }


    @Override
    public T removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 0) {
            return null;
        }

        Node<T> nodeToRemove = getNodeByIndex(index);
        if (size == 1) {
            first = last = null;
            //return nodeToRemove.element;
        } else if (index == 0) {
            Node<T> after = nodeToRemove.next;
            first = after;
            after.prev = null;
            nodeToRemove.next = null;
        } else if (index == size - 1) {
            Node<T> before = nodeToRemove.prev;
            before.next = null;
            nodeToRemove.prev = null;
        } else /*if (index > 1 && index < size - 1)*/ {
            Node<T> before = nodeToRemove.prev;
            Node<T> after = nodeToRemove.next;
            before.next = after;
            after.prev = before;
            nodeToRemove.prev = nodeToRemove.next = null;
        }

        size--;
        return nodeToRemove.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //OurLinkedList<T> ourLinkedList = new OurLinkedList<>(null, null, 0);
        first = last = null;
        size = 0;
    }

    @Override
    public boolean remove(T obj) {
        if (size == 0) {
            return false;
        }

        if (size == 1 && first.element.equals(obj)) {
            first = last = null;
            return true;
        }

        Node<T> res = first;
        for (int i = 0; i < size; i++) {
            if (res.element.equals(obj)) {
                removeById(i);
                return true;
            } else {
                res = res.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {
        if (size == 0) {
            return false;
        }

        if (size == 1 && first.element.equals(obj)) {
            return true;
        }

        Node<T> res = first;

        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (res.element == null) {
                    return true;
                } else {
                    res = res.next;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (res.element.equals(obj)) {
                return true;
            } else {
                res = res.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> backwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
