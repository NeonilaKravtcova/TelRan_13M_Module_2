package de.telran.application;

import de.telran.data.*;

public class ShapeApp {
    public static void main(String[] args) {
        Shape shape = new Circle(Color.RED, 12);
        Circle circle = new Circle(Color.BLACK, 10);
        Shape square = new Square(Color.GREEN, 8);
        //((Square)square).changeColor();

        Circle c1 = new Circle(Color.RED, 12);
        Circle c2 = new Circle(Color.GREEN, 9);

        Shape s1 = new Square(Color.YELLOW, 5);
        Shape s2 = new Square(Color.RED, 8);

        Rectangle r1 = new Rectangle(Color.BLUE, 9, 3);
        Rectangle r2 = new Rectangle(Color.YELLOW, 7, 6);

        Triangle t1 = new RightTriangle(Color.BLACK, 9, 3);
        Shape t2 = new EquilateralTriangle(Color.YELLOW, 7);
        Triangle t3 = new EquilateralTriangle(Color.RED, 8);
        Shape t4 = new RightTriangle(Color.GREEN, 3, 2);

        Shape[] shapes = {c1, t1, c2, t2, s1, s2, t3, r1, r2, t4};

        Shape.displayAreaFormShape(shapes);

        System.out.println(Shape.findMaxShapeArea(shapes));
        System.out.println();

        printArray(Shape.getShapesByColor(shapes, Color.YELLOW));
        System.out.println();
        //Метод printMessage присущ всем объектам независимо ни от чего
        //r1.printMessage();
        //t1.printMessage();

        printArray(Shape.getShapesByType(shapes, "RightTriangle"));
        System.out.println();
        printArray(Shape.getShapesByType(shapes, "Square"));
        System.out.println();
        printArray(Shape.getShapesByType(shapes, "Triangle"));
        System.out.println();
        printArray(Shape.getShapesByType(shapes, "Abcd"));
    }

    public static void printArray(Object[] objects){
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
