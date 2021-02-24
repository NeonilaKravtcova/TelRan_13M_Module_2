package de.telran;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        TwoStreams streams = new TwoStreams();

        IntStream stream1 = IntStream.iterate(0, i -> i + 2).limit(50);
        IntStream stream2 = IntStream.iterate(1, i -> i + 2).limit(50);

        streams.merge(stream1, stream2).forEach(System.out::println);

    }

}
