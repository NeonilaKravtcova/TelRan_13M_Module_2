package de.telran;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        TwoStreams streams = new TwoStreams();

        Stream<Integer> stream1 = Stream.iterate(0, i -> i + 2).limit(50);
        Stream<Integer> stream2 = Stream.iterate(1, i -> i + 2).limit(50);

        streams.merge(stream1, stream2);

    }

}
