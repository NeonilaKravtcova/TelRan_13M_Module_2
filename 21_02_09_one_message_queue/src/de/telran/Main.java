package de.telran;

public class Main {
    public static void main(String[] args) {

        OneItemStringQueue queue = new OneItemStringQueue();

        MessageSupplier supplier = new MessageSupplier(queue);
        Thread threadIn = new Thread(supplier);

        MessageConsumer consumer1 = new MessageConsumer(queue);
        MessageConsumer consumer2 = new MessageConsumer(queue);
        MessageConsumer consumer3 = new MessageConsumer(queue);

        Thread thread1 = new Thread(consumer1);
        Thread thread2 = new Thread(consumer2);
        Thread thread3 = new Thread(consumer3);

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();

        threadIn.start();

    }
}
