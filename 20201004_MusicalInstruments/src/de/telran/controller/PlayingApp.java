package de.telran.controller;

import de.telran.MusicPlayer.Piano;
import de.telran.data.Drum;
import de.telran.data.Guitar;
import de.telran.data.Playable;
import de.telran.data.Trumpet;

public class PlayingApp {
    public static void main(String[] args) {
        Guitar guitar1 = new Guitar("electro", 6);
        Guitar guitar2 = new Guitar("acoustic", 7);
        Playable guitar3 = new Guitar("acoustic",12);
        Drum drum1 = new Drum("big", 22, 16);
        Drum drum2 = new Drum("standard", 18, 14);
        Playable drum3 = new Drum("small", 16, 12);
        Trumpet trumpet1 = new Trumpet("piccolo", 101);
        Trumpet trumpet2 = new Trumpet("alt", 125);
        Playable trumpet3 = new Trumpet("bass", 139);

        Playable[] musicalInstruments = {guitar1, guitar2, guitar3, drum1, drum2, drum3,
                trumpet1, trumpet2, trumpet3};

        for (Playable p : musicalInstruments) {
            p.play();
        }

        Piano piano = new Piano();
        piano.play();
        piano.playMelody(1, 1000, 50, 69, 72, 76);
        piano.playMelody(1, 1000, 50, 69, 74, 77);
        piano.playMelody(1, 1000, 50, 67, 71, 74);
        piano.playMelody(1, 1000, 50, 67, 72, 76);
        piano.close();
        //:)
    }
}
