package de.telran.data;

import java.util.Scanner;

public class DataInput {
    private static Scanner scanner = new Scanner(System.in);

    public static double getParameter() {
        System.out.print("Enter number, please: ");
        return scanner.nextDouble();
    }

    public static char operation() {
        System.out.println("Enter operation symbol: ");
        char operation = scanner.next().charAt(0);
        while (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            System.out.print("Wrong operation symbol, enter new please");
            operation = scanner.next().charAt(0);
        }
        return operation;
    }

    public static double incorrectDelimeter(double delimeter) {
        while (delimeter == 0) {
            System.out.println("Error. Please enter not 0 number: ");
            delimeter = scanner.nextDouble();
        }
        return delimeter;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
