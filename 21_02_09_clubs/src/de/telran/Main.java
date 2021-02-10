package de.telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        FootballClub club1 = new FootballClub("Англия   ", "Ливерпуль      ", 40);
        FootballClub club2 = new FootballClub("Испания  ", "Барселона      ", 43);
        FootballClub club3 = new FootballClub("Италия   ", "Милан          ", 49);
        FootballClub club4 = new FootballClub("Аргентина", "Ривер Плейт    ", 44);
        FootballClub club5 = new FootballClub("Англия   ", "Манчестер Сити ", 50);
        FootballClub club6 = new FootballClub("Англия   ", "Челси          ", 39);
        FootballClub club7 = new FootballClub("Аргентина", "Аргентина      ", 39);
        FootballClub club8 = new FootballClub("Италия   ", "Ювентус        ", 42);
        FootballClub club9 = new FootballClub("Англия   ", "Лестер         ", 42);
        FootballClub club10 = new FootballClub("Испания  ", "Реал Мадрид    ", 43);

        List<FootballClub> clubs = new ArrayList<>(Arrays.asList(club1, club2, club3, club4, club5, club6, club7, club8, club9, club10));

        BigLeague bigLeague = new BigLeague(clubs);
        bigLeague.outPrint(bigLeague.sortByCountryAndPoints(clubs));


        //Решение в Main без класса BigLeague
        /*List<FootballClub> res = new ArrayList<>(clubs);

        res.sort(new AlphabetComparator());

        res.sort(new PointsComparator());

        for (FootballClub club : res) {
            System.out.println(club);
        }*/
    }
}
