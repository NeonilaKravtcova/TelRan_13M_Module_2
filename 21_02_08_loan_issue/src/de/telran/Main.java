package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        List<Score> scoreList = new ArrayList<>();

        Employee employee1 = new Employee("Tatiana", 20, scoreList, startTime, 100, 200);
        Employee employee2 = new Employee("Petr", 20, scoreList, startTime, 200, 300);
        GoldenEmployee employee3 = new GoldenEmployee("Vassily", 20, scoreList, startTime, 200, 300,
                50, 100, false, 0);

        employee1.start();
        employee2.start();
        employee3.start();

        employee1.join();
        employee2.join();
        employee3.join();

        outPrintScoreList(scoreList);

    }

    public static void outPrintScoreList(List<Score> scoreList) {
        for (Score scores : scoreList) {
            System.out.println(scores.toString());
        }
    }
}
