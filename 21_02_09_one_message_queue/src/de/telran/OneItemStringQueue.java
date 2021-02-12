package de.telran;

public class OneItemStringQueue {

    private final Object mutex = new Object();
    private final Object mutex2 = new Object();

    private String source;

    public void addFirst(String input) throws InterruptedException {
        System.out.println("addFirst(" + input + ") runs");
        synchronized (mutex2){
            while (source != null){
                mutex2.wait();
            }
        }
        synchronized (mutex){
            //while (source != null){
                source = input;
                mutex.notify();
            }
        //}
    }

    public String removeLast() throws InterruptedException {
        System.out.println("removeLast() runs");
        synchronized (mutex) {
            while (source == null) {
                mutex.wait();
                System.out.println("The thread id " + Thread.currentThread().getId() + " fell asleep");
            }
        }
        synchronized (mutex2){
            String res = source;
            source = null;
            System.out.println("The thread id " + Thread.currentThread().getId() + " fell asleep");
            mutex2.notify();
            return res;
        }

    }
}



