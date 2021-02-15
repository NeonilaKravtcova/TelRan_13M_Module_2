package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private static final String SEPARATOR = "#";
    private static final String WRONG_FORMAT = "wrong format";
    private static final String WRONG_OPERATION = "wrong operation";

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            String line;
            while (true) {
                line = queue.take();
                String res = handleRawString(line);
                writer.println(res);
                writer.flush();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String handleRawString(String line) {

        String[] parsedString = line.split(SEPARATOR);
        if (parsedString.length != 2) {
            return line + SEPARATOR + WRONG_FORMAT;
        }

        String stringToHandle = parsedString[0];
        String operationName = parsedString[1].toLowerCase();
        System.out.println("/" + parsedString[0] + "/ " + parsedString[1]);
        //IStringOperation operationToApply = context.getOperation(operationName);

        if (stringToHandle.equals("")){
            return line + SEPARATOR + WRONG_FORMAT;
        }
        if (context.getOperation(operationName) == null) {
            return line + SEPARATOR + WRONG_OPERATION;
        }
        return context.getOperation(operationName).operate(stringToHandle);
    }
}
