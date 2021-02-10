package de.telran;

import static de.telran.Shape.*;

public class ShapeApp {

    public static void main(String[] args) {

        Line line8 = new Line(8, CYAN, RESET,'_');
        Line line10 = new Line(10, BLUE, RESET, '/');
        Line line30 = new Line(30, RED, RESET, '\\');

        Rectangle rectangle0 = new Rectangle(3, 4, BACKGROUND_RED,'*');
        Rectangle rectangle1 = new Rectangle(5, 8, BACKGROUND_GREEN, '^');
        Rectangle rectangle2 = new Rectangle(6, 10, BACKGROUND_BLUE,'&');
        Rectangle rectangle3 = new Rectangle(10, 30, BACKGROUND_BLACK,  ' ');

        Shape[] shapes1 = new Shape[] {rectangle0, rectangle1, rectangle2};
        Picture picture1 = new Picture("TRI BOGATYRYA", "1898", shapes1, '~');
        picture1.draw();

        Shape[] shapes2 = new Shape[] {line10, line8};
        Picture picture0 = new Picture("Lines", "2020", shapes2, '~');
        Shape[] shapes3 = new Shape[] {rectangle0, picture0, line30};
        Picture picture2 = new Picture("COLLAGE", "2020", shapes3, '~');
        picture2.draw();

        Shape[] shapes4 = new Shape[] {rectangle3};
        Picture picture3 = new Picture("CHERNIY KVADRAT", "1915", shapes4, '~');
        picture3.draw();


    }
}
