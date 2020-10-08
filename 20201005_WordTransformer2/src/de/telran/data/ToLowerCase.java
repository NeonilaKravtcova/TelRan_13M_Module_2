package de.telran.data;

public class ToLowerCase implements WordChecker {
    public boolean checkLength(String input){
        return input.length() == 4;
    }

    public String action(String input){
        return input.toLowerCase();
    }
}
