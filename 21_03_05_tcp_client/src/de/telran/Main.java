package de.telran;

import java.io.*;
import java.net.Socket;

public class Main {

    static int TCP_PORT = 3000;
    public static void main(String[] args) throws IOException {
        //tool for reading console
        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));

        //create connection to the program listening to port 3000 on the "localhost" machine
        Socket socket = new Socket("localhost", TCP_PORT);

        //tool for sending lines to the port 3000
        PrintStream socketOutput = new PrintStream(socket.getOutputStream());//отправляет данные в socket

        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));//вычитывает
                                                    // данные из нашего соединения, т.е. из socket
        String line;

        //всё время вычитываем данные из консоли: вычитали строку - отправили строку
        while ((line = fromConsole.readLine()) != null && !line.equals("exit")){
            socketOutput.println(line);//отправляем строку

            String response = socketInput.readLine();//ждём ответ с сервера после отправки данных

            System.out.println(response);//распечатываем ответ с сервера
        }
    }
}
