package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {

        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationPaths();
        OperationContext context = new OperationContext(operationPaths);

        BufferedReader reader = new BufferedReader(new FileReader(FILE_INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        List<Consumer> consumers = createListConsumers(3, queue, writer, context);

        Supplier supplier = new Supplier(reader, queue);

        List<Thread> consumerThreads = createThreads(consumers);

        Thread supplierThread = new Thread(supplier);

        supplierThread.start();

        startThreads(consumerThreads);

        supplierThread.join();//ждём, пока отработает supplier
        //после этого надо прекратить работу consumer-ов

        interruptThreads(consumerThreads);

        joinThreads(consumerThreads);

        writer.close();

        reader.close();

    }

    public static List<Consumer> createListConsumers(int n, BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            consumers.add(new Consumer(queue, writer, context));
        }
        return consumers;
    }

    public static List<Thread> createThreads(List<Consumer> consumers) {
        List<Thread> threads = new ArrayList<>();
        for (Consumer consumer : consumers) {
            threads.add(new Thread(consumer));
        }
        return threads;
    }

    public static void startThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            //thread.setDaemon(true);
            thread.start();
        }
    }

    public static void interruptThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public static void joinThreads(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
