package de.telran.data;

public class Calculator {

    public static void calculation(double a, double b, char operation){
        double result;
        if (operation == '+'){
            result = a + b;
        } else if (operation == '-'){
            result = a - b;
        } else if (operation == '*'){
            result = a * b;
        } else {
            if (b == 0){
                /*System.out.println("Wrong delimiter");
                result = -1;*/
                b = DataInput.incorrectDelimeter(b);
                result = a / b;
            } else {
                result = a / b;
            }
        }
        System.out.println("Result is " + result);
    }
}
