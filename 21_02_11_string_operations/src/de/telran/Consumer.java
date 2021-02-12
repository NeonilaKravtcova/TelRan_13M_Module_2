package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private PrintWriter writer;
    private final OperationContext context;
    private final String fileName;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context, String fileName) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            String line;
            while (true) {
                line = queue.take();
                String res = handleRawString(line);
                writer = new PrintWriter(new FileWriter(fileName, true), true);
                writer.println(res);
                writer.close();
            }
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String handleRawString(String line) {
        String res;
        List<String> parsedString = Arrays.asList(line.split("#", 0));
        if (parsedString.size() == 1) {
            return line + "#wrong format";
        }
        String stringToHandle = parsedString.get(0);
        String operation = parsedString.get(1);
        if (stringToHandle == null || operation.contains("#")) {
            res = stringToHandle + "#wrong format";
        } else if (!context.getOperation(operation).getName().equals(operation)) {
            res = line + "#wrong format";
        } else {
            res = context.getOperation(operation).operate(stringToHandle);
        }
        return res;
    }
}
