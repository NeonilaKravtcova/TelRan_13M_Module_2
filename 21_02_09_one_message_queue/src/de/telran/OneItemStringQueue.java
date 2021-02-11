package de.telran;

public class OneItemStringQueue {

    private final Object mutex = new Object();

    private String source;


    public OneItemStringQueue(String source) {
        this.source = source;
    }

    public void addFirst(String input) {
        System.out.println("addFirst(" + input + ") runs");

        source = input;
        mutex.notify();
/*        synchronized (this){
            while (source != null){
                this.notifyAll();
            }
        }*/
    }

    public String removeLast() throws InterruptedException {
        System.out.println("removeLast() runs");
        synchronized (mutex) {
            while (source == null) {
                mutex.wait();
            }
            mutex.notifyAll();
        }

        String res = source;
        source = null;
        return res;
    }
}



