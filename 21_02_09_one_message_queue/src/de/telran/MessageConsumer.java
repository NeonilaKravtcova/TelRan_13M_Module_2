package de.telran;

public class MessageConsumer implements Runnable {

    private final OneItemStringQueue queue;

    public MessageConsumer(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("MessageConsumer run() runs");

        try {
            while (true) {
                String str = queue.removeLast();
                System.out.println("String " + str + " was removed");
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}
