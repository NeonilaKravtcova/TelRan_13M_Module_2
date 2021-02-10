package de.telran;

public class StringBuilderConcatenator implements IConcatenator {

    @Override
    public void concatenate(String[] strings) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < strings.length; i++) {
            res = res.append(strings[i]);
        }
    }
}
