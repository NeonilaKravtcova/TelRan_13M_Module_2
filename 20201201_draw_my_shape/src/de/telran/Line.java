package de.telran;

public class Line extends Shape {

    int length;
    String colorStart;
    String colorReset;

    public Line(int length, String colorStart, String colorReset, char symbol) {
        super(symbol);
        this.length = length;
        this.colorStart = colorStart;
        this.colorReset = colorReset;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(colorStart + symbol + colorReset);
        }

    }
}
