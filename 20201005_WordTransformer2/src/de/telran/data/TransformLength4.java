package de.telran.data;

public class TransformLength4 implements Transformable {
    public boolean checkLength(String input){
        return input.length() == 4;
    }

    public String action(String input){
        return input.toLowerCase();
    }
}
