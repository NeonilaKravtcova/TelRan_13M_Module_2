package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(qtyNumbersWithOne(-20, 29, 20, 2));
        System.out.println(qtyNumbersWithOne_v2(5, 15, 20, 1));
        System.out.println(qtyNumbersWithOne_v2(5, 45, 20, 4));
    }

    private static int qtyNumbersWithOne(int m, int n, int qtyNumbers, int argument) {
        List<Integer> numbers = createArrayNumbers(m, n, qtyNumbers);
        System.out.println(numbers);
        int res = 0;
        for (Integer number : numbers) {
            if (Integer.toString(number).contains(Integer.toString(argument))) {
                res++;
            }
        }
        return res;
    }

    private static int qtyNumbersWithOne_v2(int m, int n, int qtyNumbers, int argument){
        List<Integer> numbers = createArrayNumbers(m, n, qtyNumbers);
        System.out.println(numbers);
        int res = 0;
        for (Integer number : numbers) {
            if (checkNumber(number, argument)) {
                res++;
            }
        }
        return res;
    }

    private static boolean checkNumber(int n, int argument){
        if (n > argument){
            if (n % 10 != argument) {
                return checkNumber(n / 10, argument);
            } else return true;
        }
        return n == argument;
    }

    private static List<Integer> createArrayNumbers(int min, int max, int size) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add((int) (max - Math.random() * (max - min)));
        }
        return res;
    }
}
