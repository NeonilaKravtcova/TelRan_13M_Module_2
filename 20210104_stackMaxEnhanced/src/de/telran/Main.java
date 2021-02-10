package de.telran;

public class Main {
    public static void main(String[] args) {

        StackMax deque = new StackMax();

        for(int i = 1; i < 5; i++){
            deque.addLast(i * 3);
        }

        for(int i = 5; i < 9; i++){
            deque.addLast(i);
        }

        System.out.println(deque.getMax());

        deque.removeLast();
        System.out.println(deque.getMax());

        deque.addLast(17);
        System.out.println(deque.getMax());

        deque.addLast(34);
        System.out.println(deque.getMax());
    }

}
