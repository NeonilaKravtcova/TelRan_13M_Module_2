package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        final String FILE_INPUT = "input.txt";
        final String FILE_OUTPUT = "output.txt";


        BufferedReader reader = new BufferedReader(new FileReader(FILE_INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        OperationContext context = new OperationContext();

        Supplier supplier = new Supplier(FILE_INPUT, /*reader, */queue);

        Consumer consumer1 = new Consumer(queue, writer, context, FILE_OUTPUT);
        Consumer consumer2 = new Consumer(queue, writer, context, FILE_OUTPUT);
        Consumer consumer3 = new Consumer(queue, writer, context, FILE_OUTPUT);

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();

        new Thread(supplier).start();


    }
}
