package de.telran.application;

import de.telran.data.Calculator;
import de.telran.data.DataInput;

import java.util.Scanner;

import static de.telran.data.DataInput.*;


public class CalculatorApplication {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);//создали объект класса Scanner
        System.out.print("Enter first number, please: ");
        double a = scanner.nextDouble();
        System.out.print("Enter next, please: ");
        double b = scanner.nextDouble();*/
        double a = getParameter();
        double b = getParameter();//когда класс уже проимпортирован,
        // можно дальше использовать его без ссылки на класс
/*        System.out.print("Enter operation symbol, please: ");
        char operation = scanner.next().charAt(0);
        while (operation != '+' && operation != '-' && operation != '*' && operation != '/'){
            System.out.println("Wrong operation symbol, enter new please");
            operation = scanner.next().charAt(0);
        }*/
        char operation = DataInput.operation();
        Calculator.calculation(a, b, operation);
        closeScanner();
    }
}
