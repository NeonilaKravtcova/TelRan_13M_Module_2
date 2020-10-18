package de.telran.decorator;

public class FruitsDecorator extends AbstractDecorator {
    private static final String FRUITS = "Fruits";
    private static final double FRUITS_PRICE = 1.30;

    public FruitsDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return FRUITS;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + FRUITS_PRICE;
        System.out.println(FRUITS + " - " + FRUITS_PRICE + " Euro");
        return price;
    }
}
