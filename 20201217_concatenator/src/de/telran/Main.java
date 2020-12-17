package de.telran;

public class Main {
    public static void main(String[] args) {

        StringConcatenator stringConcatenator = new StringConcatenator();
        ConcatenationTester tester1 = new ConcatenationTester(stringConcatenator);
        tester1.test(1000, "Telran");
        tester1.test(1000, "telran");
        tester1.test(10000, "telran");
        System.out.println();

        StringBuilderConcatenator stringBuilderConcatenator = new StringBuilderConcatenator();
        ConcatenationTester tester2 = new ConcatenationTester(stringBuilderConcatenator);
        tester2.test(1000,"Telran");
        tester2.test(10000,"telran");
        tester2.test(100000,"telran");

    }
}
