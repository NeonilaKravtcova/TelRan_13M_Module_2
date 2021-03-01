package de.telran;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtCollectorTest {
    SqrtCollector sqrtCollector = new SqrtCollector();

    @Test
    public void testCollector_numbers5_minus3_10() {
        Stream<Integer> numbers = Stream.of(5, -3, 10);
        assertEquals(6.683312551921141, numbers.collect(sqrtCollector));
    }

    @Test
    public void testCollector_numbers1_to_5() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        assertEquals(3.3166247903554, numbers.collect(sqrtCollector));
    }

}
