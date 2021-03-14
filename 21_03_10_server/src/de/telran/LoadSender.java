package de.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadSender implements Runnable {

    private static final String UDP_SERVER_HOST = "localhost";

    private final int udpServerPort;//порт LoadReceiver
    private final AtomicInteger tcpConnectionsCounter;
    private int sendingFrequency;

    public LoadSender(int udpServerPort, AtomicInteger tcpConnectionsCounter, int sendingFrequency) {
        this.udpServerPort = udpServerPort;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
        this.sendingFrequency = sendingFrequency;
    }

    public void run() {

        try {
            InetAddress inetAddress = InetAddress.getByName(UDP_SERVER_HOST);
            DatagramSocket udpSocket = new DatagramSocket(udpServerPort);

            String line = String.valueOf(tcpConnectionsCounter);

            byte[] outputData = line.getBytes();

            DatagramPacket packetOut = new DatagramPacket(// datagram to send
                    outputData,
                    outputData.length,
                    inetAddress,
                    udpServerPort);

            while (true) {
                Thread.sleep(sendingFrequency);
                udpSocket.send(packetOut);// sending the datagram with sendingFrequency
            }

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
