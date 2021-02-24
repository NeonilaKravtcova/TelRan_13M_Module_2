package de.telran;

import java.util.stream.IntStream;

public class Numbers {

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(x -> n % x != 0);
    }
}
