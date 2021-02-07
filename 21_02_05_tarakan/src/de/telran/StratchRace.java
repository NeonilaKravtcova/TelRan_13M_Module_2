package de.telran;

import java.util.ArrayList;
import java.util.List;

public class StratchRace {

    List<String> names;
    int distance;
    long startTime;
    List<Score> scoreList;


    public StratchRace(List<String> names, int distance, List<Score> scoreList, long startTime) {
        this.names = names;
        this.distance = distance;
        this.scoreList = scoreList;
        this.startTime = startTime;
    }

    public void runTarakan() throws InterruptedException {

        List<Tarakan> tarakans = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        initListOfTarakans(names, tarakans, distance, scoreList, startTime);

        createThreads(tarakans, threads);

        startThreads(threads);

        joinThreads(threads);

        outPrintScoreList(scoreList);
    }

    public static void initListOfTarakans(List<String> names, List<Tarakan> tarakans, int distance,
                                          List<Score> scoreList, long startTime) {
        for (String name : names) {
            tarakans.add(new Tarakan(name, distance, scoreList, startTime));
        }
    }

    public static void createThreads(List<Tarakan> tarakans, List<Thread> threads) {
        for (Tarakan tarakan : tarakans) {
            threads.add(new Thread(tarakan));
        }
    }

    public static void startThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinThreads(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void outPrintScoreList(List<Score> scoreList) {
        for (Score scores : scoreList) {
            System.out.println(scores.toString());
        }
    }
}
