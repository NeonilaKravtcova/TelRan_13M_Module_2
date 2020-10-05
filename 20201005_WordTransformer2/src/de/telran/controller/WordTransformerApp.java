package de.telran.controller;

import de.telran.data.TransformLength3;
import de.telran.data.TransformLength4;
import de.telran.data.TransformLength6;
import de.telran.data.WordTransformer;

public class WordTransformerApp {
    public static void main(String[] args) {
        System.out.println(WordTransformer.wordTransform("Let us try to solve this", new TransformLength3()));
        System.out.println(WordTransformer.wordTransform("Let us try to solve THIS", new TransformLength4()));
        System.out.println(WordTransformer.wordTransform("Let us try to solve this method", new TransformLength6()));
    }
}
