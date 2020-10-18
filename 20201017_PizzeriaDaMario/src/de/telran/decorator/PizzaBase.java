package de.telran.decorator;

public class PizzaBase implements Pizza {
    private final static double PIZZA_BASE_PRICE = 2.50;
    final String COLOR_START = "\u001B[31m";
    final String COLOR_RESET = "\u001B[0m";

    //System.out.println("It is very tasty! But still not a pizza.\nCreate your own pizza now!\n");

    @Override
    public String getName() {
        return "-----------------------\n" + COLOR_START + "This is your own pizza:" + COLOR_RESET + "\n-----------------------";
    }

    @Override
    public double getPrice() {
        System.out.println(getName());
        System.out.println("Classical pizza base - " + PIZZA_BASE_PRICE + " Euro");
        return PIZZA_BASE_PRICE;
    }


}
