package de.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final int UDP_SERVER_PORT = 4000;
    public static final AtomicInteger TCP_CONNECTIONS_COUNTER = new AtomicInteger(0);
    public static final int SENDING_FREQUENCY = 100;

    public static void main(String[] args) {

        int tcpPort = Integer.parseInt(args[0]);

        TCPServer tcpServer = new TCPServer(UDP_SERVER_PORT, tcpPort, TCP_CONNECTIONS_COUNTER, SENDING_FREQUENCY);
        tcpServer.run();

    }
}
