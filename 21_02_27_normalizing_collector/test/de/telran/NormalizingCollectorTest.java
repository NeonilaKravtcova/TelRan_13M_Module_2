package de.telran;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class NormalizingCollectorTest {

    NormalizingCollector collector = new NormalizingCollector();

    @Test
    public void testCollect_numbers5_minus3_10(){
        Stream<Integer> numbers = Stream.of(5, -3, 10);
        List<Double> res = new ArrayList<>(Arrays.asList(0.6153846153846154, 0.0, 1.0));
        assertEquals(res, numbers.collect(collector));
    }

    @Test
    public void testCollect_numbers17_5_12_0(){
        Stream<Integer> numbers = Stream.of(17, 5, 12, 0);
        List<Double> res = new ArrayList<>(Arrays.asList(1.0, 0.29411764705882354, 0.7058823529411765, 0.0));
        assertEquals(res, numbers.collect(collector));
    }

}
