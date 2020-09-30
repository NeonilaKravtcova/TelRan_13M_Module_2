package de.telran.data;

public class Square extends Shape {
    private double side;

    public Square(Color color, double side){
        super(color);
        this.side = side;
    }

    public double getSide(){
        return side;
    }

    public void changeColor(Color color){
        super.setColor(color);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Square: " + getColor()
                + ", side " + side
                + ", area " + getArea();
    }

    @Override
    public double getArea(){
        return side * side;
    }
}
