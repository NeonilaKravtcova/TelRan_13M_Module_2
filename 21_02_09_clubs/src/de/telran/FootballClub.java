package de.telran;

public class FootballClub {
    String country;
    String name;
    int achievedPoint;

    public FootballClub(String country, String name, int achievedPoint) {
        this.country = country;
        this.name = name;
        this.achievedPoint = achievedPoint;
    }

    @Override
    public String toString() {
        return country + "   " + name + " " + achievedPoint;
    }


}
