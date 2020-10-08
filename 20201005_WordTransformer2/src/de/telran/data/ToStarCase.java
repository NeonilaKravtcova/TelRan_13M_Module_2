package de.telran.data;

public class ToStarCase implements WordChecker {
    public boolean checkLength(String input) {
        return input.length() == 6;
    }

    public String action(String input) {
        return input.replaceAll(".","*");
    }
}
