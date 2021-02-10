package de.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    /**
     * Writes the list of strings into the file, clearing it if the file exists and starts every string from new
     * line
     *
     * @param text to write
     * @param fileName of the file
     */
    public void writeList(List<String> text, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (String string : text){
                pw.println(string);
            }


        }
    }

    /**
     * reads all the lines of the file into a list
     *
     * @param fileName
     * @return list of lines
     */
    public List<String> readToList(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
                res.add(line);
            }
            return res;
        }
    }
}
