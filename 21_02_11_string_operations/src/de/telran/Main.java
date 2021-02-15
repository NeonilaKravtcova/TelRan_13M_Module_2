package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //TODO read the props file and retrieve the operation paths from it.
        //TODO Then create an instance of the OperationContext using these paths.
        OperationContext context = new OperationContext(new ConfigReader("config.props").getOperationPaths());

        final String FILE_INPUT = "input.txt";
        final String FILE_OUTPUT = "output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(FILE_INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Supplier supplier = new Supplier(reader, queue);

        List<Consumer> consumers = createListConsumers(3, queue, writer, context);

        List<Thread> threads = createThreads(consumers);

        new Thread(supplier).start();

        startThreads(threads);

        //supplierThread.join();

        //writer.close();

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
}
