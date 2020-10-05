package de.telran.data;

public class Guitar implements Playable {
    private String type;
    private int stringQty;

    public Guitar(String type, int stringQty) {
        this.type = type;
        this.stringQty = stringQty;
    }

    public String getType() {
        return type;
    }

    public int getStringQty() {
        return stringQty;
    }

    @Override
    public void play() {
        System.out.println("Plays " + getStringQty() +
                "-string " + getType() +
                " guitar");
    }

    @Override
    public void playMelody(int channel, int duration, int volume, int... notes) {
    }
}
