package de.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServer implements Runnable {
    
    private final int tcpPort;
    private final AtomicInteger tcpConnectionsCounter;

    public TCPServer(int tcpPort, AtomicInteger tcpConnectionsCounter) {
        this.tcpPort = tcpPort;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
    }

    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(tcpPort);
            ExecutorService executor = Executors.newFixedThreadPool(5);

            while (true) {
                System.out.println("TCP_PORT " + tcpPort + " is opened");

                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Connected");

                Runnable task = new TCPServerTask(socket, tcpConnectionsCounter);

                executor.execute(task);//adding task to the queue

                tcpConnectionsCounter.incrementAndGet();
                
            }

        } catch (BindException e) {
            System.out.println("Port " + tcpPort + " is already in use. Please use another one");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
