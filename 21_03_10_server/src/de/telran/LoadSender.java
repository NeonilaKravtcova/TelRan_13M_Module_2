package de.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadSender implements Runnable {

    //private static final String UDP_SERVER_HOST = "localhost";

    private final String balancerHost;
    private final int udpBalancerPort;//порт LoadReceiver
    private final AtomicInteger tcpConnectionsCounter;
    private final int sendingFrequency;
    private final int tcpPort;

    public LoadSender(String balancerHost, int udpServerPort, AtomicInteger tcpConnectionsCounter, int sendingFrequency, int tcpPort) {
        this.balancerHost = balancerHost;
        this.udpBalancerPort = udpServerPort;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
        this.sendingFrequency = sendingFrequency;
        this.tcpPort = tcpPort;
    }

    @Override
    public void run() {

        try {
            InetAddress inetAddress = InetAddress.getByName(balancerHost);
            DatagramSocket udpSocket = new DatagramSocket();//new DatagramSocket(udpServerPort);

            while (true) {
                Thread.sleep(sendingFrequency);

                String line = "TCP Port " + tcpPort + ": " + tcpConnectionsCounter.toString() + " tcp connections number";

                byte[] outputData = line.getBytes();

                DatagramPacket packetOut = new DatagramPacket(// datagram to send
                        outputData,
                        outputData.length,
                        inetAddress,
                        udpBalancerPort);

                udpSocket.send(packetOut);// sending the datagram with sendingFrequency
            }

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
