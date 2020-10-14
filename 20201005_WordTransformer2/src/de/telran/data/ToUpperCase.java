package de.telran.data;

public class ToUpperCase implements WordChecker {
    public boolean checkLength(String input){
        return input.length() == 3;
    }

    public String action(String input){
        return input.toUpperCase();
    }

}
