package de.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //readFromConsoleAndWriteToFile("text.txt");

        List<String> text = readFromConsole();
        writeToFile("text.txt", text);
    }

    public static List<String> readFromConsole() throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            List<String> res = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null && !line.equals("exit")){
                res.add(line);
            }
            return res;
        }
    }

    public static void writeToFile(String file, List<String> text) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(file)){
            for (String line : text){
                pw.println(line);
            }
        }
    }

    //Мой метод. Не соблюдается принцип единой ответственности.
    public static void readFromConsoleAndWriteToFile(String fileName) throws IOException {
        List<String> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                res.add(line);
            }
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String str : res) {
                writer.write(str);
                writer.write("\n");
            }
        }
    }
}
