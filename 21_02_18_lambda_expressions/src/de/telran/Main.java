package de.telran;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {


        UnaryOperator<List<String>> removeDuplicatesOperator = list -> new ArrayList<>(new LinkedHashSet<>(list));
        //Function<List<String>, List<String>> removeDuplicates = list -> new ArrayList<>(new LinkedHashSet<>(list));

        //Function<List<String>, HashSet<String>> removeDuplicatesThroughSet = HashSet::new;

        List<String> list = Arrays.asList("hello", "hello1", "hello2", "hello", "hello1", "hello2", "hello3");

        System.out.println(removeDuplicatesOperator.apply(list));

        int a = 5;
        int b = 6;
        int c = 7;
        Function<Integer, Integer> function = x -> a * x * x + b * x + c;
        System.out.println(function.apply(1));

        IntUnaryOperator operator = x -> a * x * x + b * x + c;
        System.out.println(operator.applyAsInt(1));

    }
}
