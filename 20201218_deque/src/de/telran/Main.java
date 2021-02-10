package de.telran;

public class Main {

    public static void main(String[] args) {
        OurDeque<Integer> arrayDeque = new OurLimitedArrayDeque<>(4);

        System.out.println("Size: " + arrayDeque.size());

        arrayDeque.addLast(5);
        System.out.println("Size: " + arrayDeque.size());
        System.out.println("First: " + arrayDeque.getFirst());
        System.out.println("Last: " + arrayDeque.getLast());
        System.out.println();

        arrayDeque.addLast(8);
        arrayDeque.addLast(-10);
        System.out.println("Size: " + arrayDeque.size());
        System.out.println("First: " + arrayDeque.getFirst());
        System.out.println("Last: " + arrayDeque.getLast());
        System.out.println();

        arrayDeque.removeFirst();
        arrayDeque.addLast(7);

        System.out.println("First: " + arrayDeque.getFirst());
        System.out.println("Last: " + arrayDeque.getLast());

    }
}
