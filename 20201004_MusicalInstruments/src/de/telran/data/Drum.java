package de.telran.data;

public class Drum implements Playable{
    private String type;
    private int diameter;
    private int depth;

    public Drum(String type, int diameter, int depth){
        this.type = type;
        this.diameter = diameter;
        this.depth = depth;
    }

    public String getType() {
        return type;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public void play() {
        System.out.println("Plays " + getType() + " drum " +
                getDiameter() + "\"x" +
                getDepth() + "\" size");
    }

    @Override
    public void playMelody(int channel, int duration, int volume, int... notes) {

    }
}
