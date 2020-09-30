package de.telran.data;

public abstract class Shape {
    private Color color;

    public Shape(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void printMessage(){
        System.out.println("Hello!");
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape: ";
    }

    public static void displayAreaFormShape(Shape[] shapes){
        for (Shape s : shapes) {
            System.out.println(s.getArea());
        }
    }

    public static Shape findMaxShapeArea(Shape[] shapes){
        Shape max = shapes[0];
        double maxArea = max.getArea();
        for (Shape s : shapes) {
            double area = s.getArea();
            if (area > maxArea) {
                max = s;
                maxArea = area;
            }
        }
        return max;
    }

    private static int shapesQtyByColor(Shape[] shapes, Color color){
        int count = 0;
        for (Shape s : shapes) {
            if (s.getColor().equals(color)){
                count++;
            }
        }
        return count;
    }

    public static Shape[] getShapesByColor(Shape[] shapes, Color color){
        Shape[] shapesByColor = new Shape[shapesQtyByColor(shapes, color)];
        int index = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getColor().equals(color)){
                shapesByColor[index] = shapes[i];
                index++;
            }
        }
        return shapesByColor;
    }


    private static int shapesQtyByType(Shape[] shapes, String type){
        int count = 0;
        for (Shape s : shapes) {
            if (s.getClass().getSimpleName().equals(type) || s.getClass().getSimpleName().contains(type)){
                count++;
            }
        }
        return count;
    }

    public static Shape[] getShapesByType(Shape[] shapes, String type){
        int index = 0;
        boolean found = false;
        Shape[] shapesByType = new Shape[shapesQtyByType(shapes, type)];
            for (Shape s : shapes){
                if (s.getClass().getSimpleName().equals(type) || s.getClass().getSimpleName().contains(type)){
                    shapesByType[index] = s;
                    index++;
                    found = true;
                }
            }
            if(!found){
                System.out.println("Shapes this type are not found");
            }
        return shapesByType;
    }
}
