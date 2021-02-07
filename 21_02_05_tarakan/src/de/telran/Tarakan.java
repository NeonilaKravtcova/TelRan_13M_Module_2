package de.telran;

import java.util.List;

public class Tarakan implements Runnable{

    final private String name;
    final private int distance;
    final List<Score> scores;
    private long startTime;

    public Tarakan(String name, int distance, List<Score> scores, long startTime) {
        this.name = name;
        this.distance = distance;
        this.scores = scores;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            int randomSpeed = randomTime(50, 100);
            try {
                Thread.sleep(randomSpeed);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        int runningTime = (int) (System.currentTimeMillis() - startTime);
        Score score = new Score(name, runningTime);
        scores.add(score);
    }

    public static int randomTime(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }
}
