package de.telran;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Supplier implements Runnable {

    private final String fileName;
    //private final BufferedReader br;
    private final BlockingQueue<String> queue;

    public Supplier(String fileName, /*BufferedReader reader, */BlockingQueue<String> queue) {
        this.fileName = fileName;
        //this.reader = reader;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.put(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
