package de.telran;

import java.util.Comparator;

public class PointsComparator implements Comparator<FootballClub> {

    public PointsComparator() {
    }

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.country.equals(club2.country)) {
            return Integer.compare(club2.achievedPoint, club1.achievedPoint);
        }
        return 0;
    }
}