package de.telran;

import java.util.*;

public class Censor {

    private final Set<String> dictionary;

    public Censor() {
        dictionary = new LinkedHashSet<>(Arrays.asList("badWord", "badWord2", "badWord3"));
    }

    public boolean verify(String text) {

        return dictionary
                .stream()
                .anyMatch(text::contains);
    }

}
