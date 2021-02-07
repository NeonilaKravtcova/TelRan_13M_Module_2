package de.telran;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.Main.findMissingNumber;
import static org.junit.Assert.assertEquals;

public class FinderTest {

    @Test
    public void findMissingNumber73_test(){
        List<Integer> list = new ArrayList<>(Arrays.asList(56, 28, 86, 3, 46, 70, 93, 1, 19, 59, 80, 50, 81, 13, 6, 88, 34, 64, 43, 96, 5, 31, 36, 29, 92, 22, 95, 27, 8, 25, 47, 7, 91, 97, 67, 55, 90, 26, 53, 71, 37, 39, 23, 52, 48, 14, 2, 10, 58, 75, 40, 82, 54, 98, 76, 84, 77, 45, 87, 32, 65, 69, 44, 51, 61, 100, 41, 74, 12, 18, 63, 16, 78, 17, 99, 85, 57, 79, 4, 21, 72, 15, 60, 35, 62, 68, 89, 83, 24, 38, 66, 94, 20, 49, 9, 30, 11, 33, 42));
        assertEquals(99, list.size());
        assertEquals(73, findMissingNumber(list));
    }

    @Test
    public void findMissingNumber29_test(){
        List<Integer> list = new ArrayList<>(Arrays.asList(56, 28, 86, 3, 46, 70, 93, 1, 19, 59, 80, 50, 81, 13, 6, 88, 34, 64, 43, 96, 5, 31, 36, 73, 92, 22, 95, 27, 8, 25, 47, 7, 91, 97, 67, 55, 90, 26, 53, 71, 37, 39, 23, 52, 48, 14, 2, 10, 58, 75, 40, 82, 54, 98, 76, 84, 77, 45, 87, 32, 65, 69, 44, 51, 61, 100, 41, 74, 12, 18, 63, 16, 78, 17, 99, 85, 57, 79, 4, 21, 72, 15, 60, 35, 62, 68, 89, 83, 24, 38, 66, 94, 20, 49, 9, 30, 11, 33, 42));
        assertEquals(99, list.size());
        assertEquals(29, findMissingNumber(list));
    }

    @Test
    public void findMissingNumber54_test() {
        List<Integer> list = new ArrayList<>(Arrays.asList(56, 28, 86, 3, 46, 70, 93, 1, 19, 59, 80, 50, 81, 13, 6, 88, 34, 64, 43, 96, 5, 31, 36, 73, 92, 22, 95, 27, 8, 25, 47, 7, 91, 97, 67, 55, 90, 26, 53, 71, 37, 39, 23, 52, 48, 14, 2, 10, 58, 75, 40, 82, 29, 98, 76, 84, 77, 45, 87, 32, 65, 69, 44, 51, 61, 100, 41, 74, 12, 18, 63, 16, 78, 17, 99, 85, 57, 79, 4, 21, 72, 15, 60, 35, 62, 68, 89, 83, 24, 38, 66, 94, 20, 49, 9, 30, 11, 33, 42));
        assertEquals(99, list.size());
        assertEquals(54, findMissingNumber(list));
    }

}
