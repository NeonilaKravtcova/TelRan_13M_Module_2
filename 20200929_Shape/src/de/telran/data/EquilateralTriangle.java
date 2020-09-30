package de.telran.data;

public class EquilateralTriangle extends Triangle{

    public EquilateralTriangle(Color color, double side) {
        super(color, side);
    }

    @Override
    public double getArea(){
        return (Math.pow(getSide(), 2) * Math.sqrt(3)) / 4;
    }

    @Override
    public String toString() {
        return super.toString() + "EquilateralTriangle: " + getColor()
                + ", side " + getSide()
                + ", area " + getArea();
    }
}
