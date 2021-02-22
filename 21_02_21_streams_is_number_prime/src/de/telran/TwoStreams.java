package de.telran;

import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class TwoStreams {

    public void merge(Stream<Integer> stream1, Stream<Integer> stream2){

        concat(stream1, stream2)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2)
                .forEach(x -> System.out.print(x + " "));

    }
}
