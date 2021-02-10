package de.telran;

import static de.telran.Shape.*;

public class Picture extends Shape {

    String name;
    String year;
    Shape[] shapes;

    public Picture(String name, String year, Shape[] shapes, char symbol) {
        super(symbol);
        this.name = name;
        this.year = year;
        this.shapes = shapes;
    }

    @Override
    public void draw(){
        (new Line(10, BLACK, RESET,'~')).draw();
        System.out.print(" " + name.toUpperCase() + " (" + year + ") ");
        (new Line(10, BLACK, RESET,'~')).draw();
        System.out.println("\n");
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println();
        }
        (new Line(25 + name.length() + year.length(), BLACK, RESET, '~')).draw();
        System.out.println("\n");
    }

}
