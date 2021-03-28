package de.telran;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "application.props";
    private static final String UDP_BALANCER_PORT = "udp.balancer.port";
    private static final String BALANCER_HOST = "balancer.host";
    public static final String SENDING_FREQUENCY = "sending.frequency";

    public static void main(String[] args) throws IOException {

        int tcpPort = Integer.parseInt(args[0]);

        String propsPath = args.length > 1 ? args[1] : DEFAULT_PROPS_PATH;
        ApplicationProperties properties = new ApplicationProperties(propsPath);

        final AtomicInteger tcpConnectionsCounter = new AtomicInteger();

        int udpBalancerPort = Integer.parseInt(properties.getProperty(UDP_BALANCER_PORT));

        int sendingFrequency = Integer.parseInt(properties.getProperty(SENDING_FREQUENCY));

        String balancerHost = properties.getProperty(BALANCER_HOST);

        LoadSender loadSender = new LoadSender(balancerHost, udpBalancerPort, tcpConnectionsCounter, sendingFrequency, tcpPort);
        new Thread(loadSender).start();

        TCPServer tcpServer = new TCPServer(tcpPort, tcpConnectionsCounter);
        //tcpServer.run();
        new Thread(tcpServer).start();

    }
}
