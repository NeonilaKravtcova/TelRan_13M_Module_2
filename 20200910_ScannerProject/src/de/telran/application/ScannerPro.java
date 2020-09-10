package de.telran.application;

import de.telran.data.DataInputOutput;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerPro {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter size of array, please: ");
        int arrayLength = scanner.nextInt();

        int[] myArray = new int[arrayLength];
        fillArray(myArray);

        System.out.print("Enter number to delete: ");
        int deleteNumber = scanner.nextInt();

        //boolean checking = checkNumber(myArray, deleteNumber);
        printResult(myArray, checkNumber(myArray, deleteNumber), deleteNumber);

        scanner.close();

        System.out.println(Arrays.toString(reverse(myArray)));
    }

    public static int[] reverse(int[] array){
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = array[array.length - 1 - i];
        }
        return output;
    }

    public static int[] fillArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a number: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static boolean checkNumber(int[] array, int number){
        for (int element : array){
            if (element == number){
                return true;
            }
        }
        return false;
    }

    public static int[] newArray(int[] array, int number){
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

    public static void printResult(int[] array, boolean check, int number){
        if (check) {
            System.out.println("Your number exists in a given array )");
            System.out.println(Arrays.toString(newArray(array, number)));
        } else {
            System.out.println("The number does not exist in the array!");
        }
    }
}
