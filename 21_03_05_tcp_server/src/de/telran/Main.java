package de.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static int TCP_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(TCP_PORT);



        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected");

            Runnable task = new ServerTask(socket);

            Thread thread = new Thread(task);

            thread.start();

        }
    }
}
