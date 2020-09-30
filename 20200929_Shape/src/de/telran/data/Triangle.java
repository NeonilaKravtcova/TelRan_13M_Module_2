package de.telran.data;

public abstract class Triangle extends Shape {
    private double side;

    public Triangle(Color color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide(){
        return side;
    }

}
