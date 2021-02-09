package de.telran;

import java.util.List;
import java.util.Random;

public class GoldenEmployee extends Thread{
    String name;
    private final int creditsQty;
    final List<Score> scores;
    private final long startTime;
    private final int minSpeed;
    private final int maxSpeed;
    private final int minTurboSpeed;
    private final int maxTurboSpeed;
    private boolean dawned;
    private int count = 0;

    public GoldenEmployee(String name, int creditsQty, List<Score> scores, long startTime, int minSpeed, int maxSpeed,
                    int minTurboSpeed, int maxTurboSpeed, boolean dawned, int count) {
        this.name = name;
        this.creditsQty = creditsQty;
        this.scores = scores;
        this.startTime = startTime;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.minTurboSpeed = minTurboSpeed;
        this.maxTurboSpeed = maxTurboSpeed;
        this.dawned = dawned;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= creditsQty; i++) {
            System.out.println("Credit No. " + i);
            int currentSpeed = currentSpeed(minSpeed, maxSpeed, minTurboSpeed, maxTurboSpeed, dawned, count);
            try {
                System.out.println("CurrentSpeed" + i +" " + name + " = " + currentSpeed);
                Thread.sleep(currentSpeed);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        int workingTime = (int) (System.currentTimeMillis() - startTime);
        System.out.println(scores.add(new Score(name, workingTime)));
    }

    private int currentSpeed(int minSpeed, int maxSpeed, int minTurboSpeed, int maxTurboSpeed, boolean dawned, int count) {
        if (!dawned){
            System.out.println(name + " is not dawned");
            if (isDawned()){
                System.out.println("and " + name + " got Dawn");
                this.dawned = true;
                this.count++;
                return randomInt(minTurboSpeed, maxTurboSpeed);
            }
        } else {
            System.out.println(name + " is dawned");
            if (count < 3){
                System.out.println("count = " + count);
                this.count++;
            } else {
                System.out.println("count >= 3");
                this.count = 0;
                this.dawned = false;
                return randomInt(minSpeed, maxSpeed);
            }
            return randomInt(minTurboSpeed, maxTurboSpeed);
        }
        return randomInt(minSpeed, maxSpeed);
    }

    public static boolean isDawned(){
        return new Random().nextInt(100) < 20;
    }

    public static int randomInt(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }
}
