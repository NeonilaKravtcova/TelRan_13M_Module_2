package de.telran.decorator;

public class SeaFoodsDecorator extends AbstractDecorator {
    private static final String SEAFOOD = "Fish";
    private static final double SEAFOOD_PRICE = 1.70;

    public SeaFoodsDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return SEAFOOD;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + SEAFOOD_PRICE;
        System.out.println(SEAFOOD + " - " + SEAFOOD_PRICE + " Euro");
        return price;
    }
}
