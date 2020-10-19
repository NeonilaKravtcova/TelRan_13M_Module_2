package de.telran.decorator;

public class CheeseDecorator extends AbstractDecorator {
    private static final String CHEESE = "Cheese";
    private static final double CHEESE_PRICE = 1.70;

    public CheeseDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return CHEESE;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + CHEESE_PRICE;
        System.out.println(CHEESE + " - " + CHEESE_PRICE + " Euro");
        return price;
    }
}
