package de.telran;

import java.util.Comparator;

public class ComparatorByTwoFields implements Comparator<FootballClub> {

    public ComparatorByTwoFields() {
    }

    Comparator<FootballClub> compareByName = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            return club1.country.compareToIgnoreCase(club2.country);
        }
    };

    Comparator<FootballClub> compareByPoints = new Comparator<FootballClub>(){
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            if (club1.country.equals(club2.country)) {
                return Integer.compare(club2.achievedPoint, club1.achievedPoint);
            }
            return 0;
        }
    };

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        Comparator<FootballClub> comparator = compareByName.thenComparing(compareByPoints);
        return comparator.compare(club1, club2);
    }

}
