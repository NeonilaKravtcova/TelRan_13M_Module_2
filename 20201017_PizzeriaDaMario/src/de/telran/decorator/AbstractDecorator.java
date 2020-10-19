package de.telran.decorator;

public abstract class AbstractDecorator implements Pizza {
    private Pizza pizza;

    public AbstractDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String toString() {
        return "-----------------------\nTotal price: " + getPrice() + " Euro\n";
    }
}
