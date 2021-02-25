package de.telran;

import java.util.*;
import java.util.stream.Collectors;

public class Censor {

    private final Set<String> dictionary;

    //Этот конструктор позволит менять объект words, а значит и сам словарь, что не соответствует условиям задачи
/*    public Censor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }*/

    public Censor(Collection<String> words) {

        dictionary = words
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public boolean verify(String text) {

        return Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .anyMatch(dictionary::contains);
    }

}


