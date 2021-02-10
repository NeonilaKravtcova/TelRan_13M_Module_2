package de.telran;

public class StringConcatenator implements IConcatenator {

    @Override
    public void concatenate(String[] strings) {
        String res = strings[0];
        for (int i = 1; i < strings.length; i++) {
            res += strings[i];
        }
    }
}
