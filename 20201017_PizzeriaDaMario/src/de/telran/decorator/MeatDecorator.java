package de.telran.decorator;

public class MeatDecorator extends AbstractDecorator {
    private static final String MEAT = "Meat";
    private static final double MEAT_PRICE = 1.70;

    public MeatDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return MEAT;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + MEAT_PRICE;
        System.out.println(MEAT + " - " + MEAT_PRICE + " Euro");
        return price;
    }
}
