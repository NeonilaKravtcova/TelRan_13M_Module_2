package de.telran;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static de.telran.Main.findMissingNumber;
import static de.telran.Main.findMissingNumber2;

import static org.junit.Assert.assertEquals;

public class FinderTest {

    @Test
    public void findMissingNumber73_test(){
        List<Integer> list = createArray(100, 73);
        assertEquals(99, list.size());
        assertEquals(73, findMissingNumber(list));
        assertEquals(73, findMissingNumber2(list));
    }

    @Test
    public void findMissingNumber29_test(){
        List<Integer> list = createArray(100, 29);
        assertEquals(99, list.size());
        assertEquals(29, findMissingNumber(list));
        assertEquals(29, findMissingNumber2(list));
    }

    @Test
    public void findMissingNumber54_test() {
        List<Integer> list = createArray(100, 1);
        assertEquals(99, list.size());
        assertEquals(1, findMissingNumber(list));
        assertEquals(1, findMissingNumber2(list));
    }



    public static List<Integer> createArray(int n, int missingNumber){
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        array.remove(missingNumber - 1);
        Collections.shuffle(array);
        return array;
    }

}
