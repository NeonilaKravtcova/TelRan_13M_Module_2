package de.telran.data;

public class WordTransformer {
    public static String wordTransform(String input, WordChecker checker) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (checker.checkLength(strings[i])) {
                strings[i] = checker.action(strings[i]);
            }
        }
        return String.join(" ", strings);
    }
}
