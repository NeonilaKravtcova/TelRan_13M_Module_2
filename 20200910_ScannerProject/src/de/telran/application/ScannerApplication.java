package de.telran.application;

import de.telran.data.DataInputOutput;
import de.telran.data.DataProcessing;

import java.util.Arrays;

public class ScannerApplication {
    public static void main(String[] args) {
        int[] myArray = DataProcessing.fillArray(DataInputOutput.createEmptyArray());
        int number = DataInputOutput.numberToDelete();
        boolean check = DataProcessing.checkNumber(myArray, number);
        DataInputOutput.printResult(myArray, check, number);
        System.out.println(Arrays.toString(DataProcessing.reverse(myArray)));
    }
}
