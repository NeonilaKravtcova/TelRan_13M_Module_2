package de.telran;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Supplier implements Runnable {

    private final BufferedReader reader;
    private final BlockingQueue<String> queue;

    public Supplier(BufferedReader reader, BlockingQueue<String> queue) {
        this.reader = reader;
        this.queue = queue;
    }

    @Override
    public void run() {
        try  {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.put(line);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
