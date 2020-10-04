package de.telran.data;

public class Trumpet implements Playable{
    private String type;
    private int diameter;

    public Trumpet(String type, int diameter){
        this.type = type;
        this.diameter = diameter;
    }

    public String getType(){
        return type;
    }

    public int getDiameter(){
        return diameter;
    }

    @Override
    public void play(){
        System.out.println("Plays " + getType() + " trumpet, " + ((char)216) +
                getDiameter() + " mm");
    }

    @Override
    public void playMelody(int channel, int duration, int volume, int... notes) {

    }
}
