package de.telran;

import java.util.stream.IntStream;

public class FactorialCounter {

    public int getFactorial(int n){

        return IntStream.rangeClosed(1, n)
                .reduce(1, (oldValue, x) -> oldValue * x);
    }

}
