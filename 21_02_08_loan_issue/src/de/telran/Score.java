package de.telran;

public class Score {
    String name;
    int seconds;

    public Score(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return name + " - " + seconds + " scores";
    }
}
