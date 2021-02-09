package de.telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = createArray(100);
        System.out.println(list);
        System.out.println(findMissingNumber(list));
        System.out.println();

        System.out.println(findMissingNumber2(list));
    }

    public static int findMissingNumber(List<Integer> input){
        int sum = 0;
        for (Integer i : input) {
            sum += i;
        }
        int n = input.size() + 1;
        return n * (n + 1) / 2 - sum;
    }

    public static int findMissingNumber2(List<Integer> input){
        List<Integer> inputCopy = new ArrayList<>(input);
        Collections.sort(inputCopy);
        for (int i = 0; i <= inputCopy.size(); i++) {
            if (inputCopy.get(i) != i + 1){
                return i + 1;
            }
        }
        return 0;
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
}
