package de.telran;

import java.util.stream.IntStream;

public class OddNumbersSum {

    public int getSum(int a, int b){
        return IntStream.rangeClosed(a, b)
                .sum()/*reduce(a, (oldValue, x) -> oldValue + x)*/;
    }
}
