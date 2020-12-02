package de.telran.data;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(Color color, double width, double length) {
        super(color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return super.toString() + "Rectangle: " + getColor()
                + ", width " + width
                + ", length " + length
                + ", area " + getArea();
    }

    @Override
    public double getArea(){
        return width * length;
    }
}
