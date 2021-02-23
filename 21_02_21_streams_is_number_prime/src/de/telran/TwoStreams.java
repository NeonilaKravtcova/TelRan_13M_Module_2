package de.telran;

import java.util.stream.IntStream;

public class TwoStreams {

    public IntStream merge(IntStream stream1, IntStream stream2){

        return IntStream.concat(stream1, stream2)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2);

    }

}
