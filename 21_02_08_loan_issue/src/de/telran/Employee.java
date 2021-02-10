package de.telran;

import java.util.List;

public class Employee extends Thread {

    String name;
    private final int creditsQty;
    final List<Score> scores;
    private final long startTime;
    private final int minSpeed;
    private final int maxSpeed;

    public Employee(String name, int creditsQty, List<Score> scores, long startTime, int minSpeed, int maxSpeed) {
        this.name = name;
        this.creditsQty = creditsQty;
        this.scores = scores;
        this.startTime = startTime;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void run() {
        for (int i = 1; i <= creditsQty; i++) {
            System.out.println("Credit No. " + i);
            int currentSpeed = randomInt(minSpeed, maxSpeed);
            try {
                System.out.println("CurrentSpeed" + i + " " + name + " = " + currentSpeed);
                Thread.sleep(currentSpeed);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        int workingTime = (int) (System.currentTimeMillis() - startTime);
        scores.add(new Score(name, workingTime));
    }

    public static int randomInt(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }
}
