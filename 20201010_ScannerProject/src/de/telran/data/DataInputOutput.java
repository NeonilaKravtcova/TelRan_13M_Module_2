package de.telran.data;

import java.util.Arrays;
import java.util.Scanner;

public class DataInputOutput {
    static Scanner scanner = new Scanner(System.in);

    public static int[] createEmptyArray() {
        System.out.print("Enter size of array, please: ");
        return new int[scanner.nextInt()];
    }

    public static int numberToDelete() {
        System.out.print("Enter number to delete: ");
        return scanner.nextInt();
    }

    public static void printResult(int[] array, boolean check, int number) {
        if (check) {
            System.out.println("Your number exists in this array");
            System.out.println(Arrays.toString(DataProcessing.newArray(array, number)));
        } else {
            System.out.println("The number does not exist in this array");
        }
    }
}

