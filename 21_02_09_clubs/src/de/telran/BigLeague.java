package de.telran;

import java.util.ArrayList;
import java.util.List;

public class BigLeague {
    private List<FootballClub> clubs;

    public BigLeague(List<FootballClub> clubs) {
        this.clubs = clubs;
    }

    public List<FootballClub> sortByCountryAndPoints(List<FootballClub> clubs) {
        List<FootballClub> res = new ArrayList<>(clubs);

        //res.sort(new AlphabetComparator());

        //res.sort(new PointsComparator());

        res.sort(new ComparatorByTwoFields());

        return res;
    }

    public void outPrint(List<FootballClub> clubs) {
        for (FootballClub club : clubs) {
            System.out.println(club);
        }
    }
}
