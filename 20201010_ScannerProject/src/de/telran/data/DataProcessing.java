package de.telran.data;

import java.util.Scanner;

public class DataProcessing {
    static Scanner scanner = new Scanner(System.in);

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print("Enter a number : ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static boolean checkNumber(int[] array, int number) {
        for (int element : array) {
            if (element == number) {
                return true;
            }
        }
        return false;
    }

    public static int[] newArray(int[] array, int number) {
        int count = 0;
        int[] output = new int[array.length - 1];
        for (int i : array) {
            if (number != i) {
                output[count] = i;
                count++;
            }
        }
        return output;
    }

    public static int[] reverse(int[] array) {
        System.out.println("Your reversed original array: ");
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = array[array.length - 1 - i];
        }
        return output;
    }
}

