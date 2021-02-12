package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageSupplier implements Runnable{

    private final OneItemStringQueue queue;

    public MessageSupplier(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("MessageSupplier run() runs");
        readFromConsole();

    }

    public void readFromConsole(){
        System.out.println("readFromConsole runs");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while ((line = reader.readLine()) != null && !line.equals("exit")){
                queue.addFirst(line);
            }
            //return reader.readLine();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //return null;
    }

}
