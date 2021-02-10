package de.telran;

import java.util.Comparator;

public class AlphabetComparator implements Comparator<FootballClub> {

    public AlphabetComparator() {
    }

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        return club1.country.compareToIgnoreCase(club2.country);
    }
}
