package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    public static final String SEPARATOR = "#";
    public static final String WRONG_FORMAT = "wrong format";
    public static final String WRONG_OPERATION = "wrong operation";

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

        boolean isAlive = true;

        while (isAlive) {
            try {
                String line;
                //while (true) {
                line = queue.take();
                String res = handleRawString(line);
                writer.println(res);
                //writer.flush();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                isAlive = false;
            }
        }

        //finish the queue - когда мы знаем, что в очереди больше не появится элементов
        while (true) {
            String line;

            try {
                line = queue.remove();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                break;
            }

            String res = handleRawString(line);
            writer.println(res);
        }
    }

    String handleRawString(String line) {

        String[] parsedString = line.split(SEPARATOR);
        if (parsedString.length != 2) {
            return line + SEPARATOR + WRONG_FORMAT;
        }

        String stringToHandle = parsedString[0];
        String operationName = parsedString[1]/*.toLowerCase()*/;

        IStringOperation operationToApply = context.getOperation(operationName);

        if (stringToHandle.equals("")){
            return line + SEPARATOR + WRONG_FORMAT;
        }
        if (context.getOperation(operationName) == null) {
            return line + SEPARATOR + WRONG_OPERATION;
        }
        return operationToApply.operate(stringToHandle);
    }
}

