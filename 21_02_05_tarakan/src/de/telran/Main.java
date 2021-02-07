package de.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        int distance = 10;
        List<Score> scoreList = new ArrayList<>();
        List<String> names = new ArrayList<>(Arrays.asList("Tarakashka", "Fedor", "Ivan", "Fekla", "Stepanida",
                "Aglaya", "Egor", "Timofey", "Superman", "Stepan"));

        new StratchRace(names, distance, scoreList, startTime).runTarakan();

    }
}

