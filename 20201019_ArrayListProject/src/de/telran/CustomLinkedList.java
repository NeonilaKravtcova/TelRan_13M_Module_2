package de.telran;
//Так как мы не знаем, какого типа массив у нас будет, мы делаем класс универсальным и для этого используем дженерики(generics) <E>

public class CustomLinkedList<E> implements CustomList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    //CustomLinkedList list = new CustomLinkedList(); - создали объект
    //{} first = null, last = null, size = 0; - при этом у нас будут такие значения

    //e1(next = null, prev = null), first = e1, last = null, size = 1};
    //e1(next = e2, prev = null), first = e1, last = null, size = 1};



    //Создаём такой объект связанного списка,
    // который хранит в себе значение и ссылки на предыдущий и последующий элементы
    private static class Node<E>{
        E value;
        Node next;
        Node prev;

        public Node(E value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public E getValue() {
            return value;
        }
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E o) {
        if (size > 0){
            Node newNode = new Node(o, null, last);
            last.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(o, null, null);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node ret = getNode(index);
        return (E)ret.value;
    }

    private Node getNode(int index){
        Node nodeToFind = first;
        for (int i = 0; i < index; i++) {
            nodeToFind = nodeToFind.next;
        }
        return nodeToFind;
    }

    @Override
    public E removeById(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node ret = getNode(index);
        ret.prev.next = ret.next;
        ret.next.prev = ret.prev;
        size--;
        return (E)ret.value;
    }

    @Override
    public boolean remove(E e) {
        if (e.equals(first.value)){
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }
        if (e.equals(last.value)){
            last = last.prev;
            last.next = null;
            size--;
            return true;
        }
        for (Node node = first.next; node != null; node = node.next) {
            if (e.equals(node.value)){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                return true;
            }
        }
        return false;
    }
}
