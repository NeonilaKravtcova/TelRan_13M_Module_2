package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServerTask implements Runnable {

    private final Socket socket;
    private final AtomicInteger tcpConnectionsCounter;

    public TCPServerTask(Socket socket, AtomicInteger tcpConnectionsCounter) {
        this.socket = socket;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
    }

    @Override
    public void run() {

        PrintStream socketOutput;
        BufferedReader socketInput;

        String line;

        while (true) {
            String threadName = Thread.currentThread().getName();

            try {
                socketOutput = new PrintStream(socket.getOutputStream());
                socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                if ((line = socketInput.readLine()) != null) {
                    String response = "Handled by server "
                            + socket.getInetAddress().getHostName()
                            + ", port "
                            + socket.getPort()
                            + ": "
                            + line;

                    socketOutput.println(response);

                    tcpConnectionsCounter.decrementAndGet();

                    System.out.println("Hello " + threadName);

                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Connection reset. " + threadName + " is closed");
                break;
            }
        }
    }
}

