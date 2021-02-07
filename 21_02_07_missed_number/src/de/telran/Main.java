package de.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = createArray(100);
        System.out.println(list);
        System.out.println(findMissingNumber(list));
    }

    public static List<Integer> createArray(int n){
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        array.remove((int) (Math.random() * (n - 1)));
        Collections.shuffle(array);
        return array;
    }

    public static int findMissingNumber(List<Integer> input){
        int sum = 0;
        for (Integer i : input) {
            sum += i;
        }
        int n = input.size() + 1;
        return n * (n + 1) / 2 - sum;
    }
}
