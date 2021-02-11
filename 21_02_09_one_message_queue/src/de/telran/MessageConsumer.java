package de.telran;

public class MessageConsumer implements Runnable {

    private OneItemStringQueue queue;

    public MessageConsumer(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("MessageConsumer run() runs");
        while (true){
            try {
                String str = queue.removeLast();
                System.out.println("String " + str + " was removed");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            //Здесь на каждой итерации вычитываем очередь и распечатываем сообщение
            //TODO accept an item from our one message queue and handle it (for example just print it out)
        }


    }
}
