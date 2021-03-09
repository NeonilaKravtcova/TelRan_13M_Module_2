package de.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static int TCP_PORT = 3000;
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(TCP_PORT);

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
