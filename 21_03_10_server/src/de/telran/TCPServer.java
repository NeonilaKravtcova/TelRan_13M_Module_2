package de.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServer implements Runnable {
    
    int tcpPort;
    AtomicInteger tcpConnectionsCounter;

    public TCPServer(int tcpPort, AtomicInteger tcpConnectionsCounter) {
        this.tcpPort = tcpPort;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(tcpPort);
            ExecutorService executor = Executors.newFixedThreadPool(10);

            while (true) {
                System.out.println("TCP Port " + tcpPort + " is opened");

                Socket socket = serverSocket.accept();;

                System.out.println("Connected");

                tcpConnectionsCounter.incrementAndGet();

                Runnable task = new TCPServerTask(socket, tcpConnectionsCounter);

                executor.execute(task);//adding task to the queue
                
            }

        } catch (BindException e) {
            System.out.println("Port " + tcpPort + " is already in use. Please use another one");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
