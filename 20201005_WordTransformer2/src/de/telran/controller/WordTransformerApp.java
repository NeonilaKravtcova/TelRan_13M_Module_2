package de.telran.controller;

import de.telran.data.ToUpperCase;
import de.telran.data.ToLowerCase;
import de.telran.data.ToStarCase;
import de.telran.data.WordTransformer;

public class WordTransformerApp {
    public static void main(String[] args) {
        System.out.println(WordTransformer.wordTransform("Let us try to solve this", new ToUpperCase()));
        System.out.println(WordTransformer.wordTransform("Let us try to solve THIS", new ToLowerCase()));
        System.out.println(WordTransformer.wordTransform("Let us try to solve this method", new ToStarCase()));
    }

}
