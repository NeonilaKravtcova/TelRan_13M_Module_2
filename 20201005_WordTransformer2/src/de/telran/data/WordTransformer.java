package de.telran.data;

public class WordTransformer {
    public static String wordTransform(String input, Transformable tr) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (tr.checkLength(strings[i])) {
                strings[i] = tr.action(strings[i]);
            }
        }
        return String.join(" ", strings);
    }
}
