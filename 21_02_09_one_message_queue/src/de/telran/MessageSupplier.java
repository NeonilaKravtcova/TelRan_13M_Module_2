package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MessageSupplier implements Runnable{

    private OneItemStringQueue queue;

    public MessageSupplier(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("MessageSupplier run() runs");
        addToQueue(readFromConsole());

    }

    public String readFromConsole(){
        System.out.println("readFromConsole runs");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addToQueue(String input){
        System.out.println("addToQueue runs");
        System.out.println(input);
        queue.addFirst(input);
    }
}
