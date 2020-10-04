package de.telran.data;

public interface Playable {
    void play();

    void playMelody(int channel, int duration, int volume, int... notes);
}
