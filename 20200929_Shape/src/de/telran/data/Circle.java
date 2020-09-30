package de.telran.data;

public class Circle extends Shape{
    public double radius;

    public Circle(Color color, double radius){
        super(color);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public String toString(){
        return super.toString()
                + "Circle: " + getColor()
                + ", radius " + radius
                + ", area " + getArea();
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
}
