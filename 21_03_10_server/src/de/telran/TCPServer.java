package de.telran;

import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TCPServer {

    private final static int UDP_SERVER_PORT = 4000;

    private static int serversCounter;

    public static void main(String[] args) throws Exception {

        while (serversCounter >= 0 && serversCounter < args.length) {
            try {
                int TCP_PORT = Integer.parseInt(args[serversCounter]);

                try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {

                    while (true) {
                        System.out.println("TCP_PORT " + TCP_PORT + " is opened");

                        Socket socket = serverSocket.accept();

                        System.out.println("Connected");

                        Runnable task = new TCPServerTask(socket);

                        Thread thread = new Thread(task);

                        thread.start();

                    }
                }

            } catch (BindException e) {

                serversCounter++;

                if (serversCounter == args.length) {
                    System.out.println("No free ports available. Please contact a system administrator.");
                }
            }
        }

        //Our server as a UDP CLIENT
        //TODO realise sending load data to Balance every minute

        //ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        //scheduler.scheduleAtFixedRate(new LoadData(UDP_SERVER_PORT), 0, 1, TimeUnit.MINUTES);

        LoadData loadData = new LoadData(UDP_SERVER_PORT);
        loadData.sendToBalance();
    }
}
