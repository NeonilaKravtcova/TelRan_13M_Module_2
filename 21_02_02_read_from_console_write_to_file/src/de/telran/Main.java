package de.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        readFromConsoleAndWriteToFile("text.txt");
    }

    public static void readFromConsoleAndWriteToFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                res.add(line + "\n");
            }
            try (FileWriter writer = new FileWriter(fileName)) {
                for (String str : res) {
                    writer.write(str);
                }
            }
        }
    }
}
