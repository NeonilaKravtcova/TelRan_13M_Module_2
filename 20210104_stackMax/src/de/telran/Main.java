package de.telran;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        StackMax deque = new StackMax(new ArrayDeque<>());

        for (int i = 0; i < 8; i++) {
            deque.addLast(i * 2);
        }

        System.out.println(deque.getMax());

        deque.removeLast();
        System.out.println(deque.getMax());

        deque.addLast(5);
        System.out.println(deque.getMax());

        deque.addLast(34);
        System.out.println(deque.getMax());

    }
}