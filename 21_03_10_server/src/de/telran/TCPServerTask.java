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

        String line;

        String threadName = Thread.currentThread().getName();

        try (PrintStream socketOutput = new PrintStream(socket.getOutputStream());
             BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while ((line = socketInput.readLine()) != null) {
                String response = "Handled by server "
                        + socket.getInetAddress().getHostName()
                        + ", port "
                        + socket.getPort()
                        + ": "
                        + line;

                socketOutput.println(response);

                System.out.println("Hello " + threadName);
            }
            tcpConnectionsCounter.decrementAndGet();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Connection reset. " + threadName + " is closed");
        }
    }
}
