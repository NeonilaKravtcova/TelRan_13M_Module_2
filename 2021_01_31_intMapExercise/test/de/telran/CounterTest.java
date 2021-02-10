package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CounterTest {

    Map<Integer, Integer> map = new HashMap<>();
    Counter counter = new Counter();

    @Test
    public void test1(){
        map.put(1, 2);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 1);
        Assert.assertEquals(map, counter.repeatCounter(Arrays.asList(1, 2, 4, 2, 3, 1)));
    }

    @Test
    public void test2(){
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 1);
        map.put(8, 3);
        map.put(-5, 1);
        Assert.assertEquals(map, counter.repeatCounter(Arrays.asList(2, 8, 3, 8, 1, 1, 1, -5, 2, 2, 8, 2)));
    }
}
