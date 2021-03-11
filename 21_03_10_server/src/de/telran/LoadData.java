package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class LoadData {

    private static final int PACKET_SIZE = 1024;
    private DatagramSocket udpSocket;
    private int port;

    public LoadData(int port) throws IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }


    public void sendToBalance() throws Exception {
        //InetAddress inetAddress = InetAddress.getByName(UDP_SERVER_HOST);
        InetAddress inetAddress = InetAddress.getLocalHost();
        //DatagramSocket udpSocket = new DatagramSocket();

        //TODO collect load data instead of reading console
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));//read console

        String line;

        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            byte[] outputData = line.getBytes();

            DatagramPacket packetOut = new DatagramPacket(// datagram to send
                    outputData,
                    outputData.length,
                    inetAddress,
                    port);

            udpSocket.send(packetOut);// sending the datagram
            udpSocket.close();

            byte[] inputData = new byte[PACKET_SIZE];
            DatagramPacket packetIn = new DatagramPacket(inputData, PACKET_SIZE);
            udpSocket.receive(packetIn);//принимаем данные и вкладываем их в объект packetIn

            String fromServer = new String(inputData, 0, packetIn.getLength());
            System.out.println(fromServer);
        }
    }
}
