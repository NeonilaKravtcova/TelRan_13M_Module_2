package de.telran.entity;

public class Rectangle extends Shape {

    int height;
    int width;
    String color;

    public Rectangle(int height, int width, String color, char symbol) {
        super(symbol);
        this.height = height;
        this.width = width;
        this.color = color;
    }

    @Override
    public void draw() {
        (new Line(width, Line.BLACK, Shape.RESET, symbol)).draw();
        System.out.println();
        for (int i = 1; i < height - 1; i++) {
            System.out.print(symbol);
            (new Line(width - 2, color, Line.RESET,' ')).draw();
            System.out.print(symbol);
            System.out.println();
        }
        (new Line(width, Line.BLACK, Line.RESET, symbol)).draw();
        System.out.println();
    }
}
