package de.telran;

import java.util.stream.IntStream;

public class OddNumbersSum {

    public int getSum(int a, int b){
        return IntStream.rangeClosed(a, b)
                .filter(x -> x % 2 == 1)
                .sum();
    }
}
