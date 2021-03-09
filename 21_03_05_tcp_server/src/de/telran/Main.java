package de.telran;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static int TCP_PORT = 3000;
    private static final String OUTPUT = "output.txt";


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        ServerSocket serverSocket = new ServerSocket(TCP_PORT);//мы забронировали 3000-ый порт для нашей программы
        // на этой машине

/*        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationPaths();
        OperationContext operationContext = new OperationContext(operationPaths);


        ExecutorService executor = Executors.newFixedThreadPool(10);*/
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected");

            Runnable task = () -> {
                PrintStream socketOutput;
                BufferedReader socketInput;

                String line;

                while (true) {
                    String threadName = Thread.currentThread().getName();
                    try {
                        socketOutput = new PrintStream(socket.getOutputStream());
                        socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        if ((line = socketInput.readLine()) != null) {
                            String response = "Handled by server: " + line;

                            socketOutput.println(response);

                            System.out.println("Hello " + threadName);

                            writer.write(threadName + ": " + line.toUpperCase());
                            writer.append('\n');
                            writer.flush();
                        }
                    } catch (IOException e) {
                        //e.printStackTrace();
                        System.out.println("Connection reset. " + threadName + " is closed");
                        break;
                    }
                }
            };

            Thread thread = new Thread(task);

            thread.start();

        }
    }
}
