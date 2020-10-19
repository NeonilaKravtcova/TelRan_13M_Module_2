package de.telran.decorator;

public class FreshVegetablesDecorator extends AbstractDecorator {
    private static final String FRESH_VEGETABLES = "Fresh vegetables";
    private static final double FRESH_VEGETABLES_PRICE = 1.30;

    public FreshVegetablesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getName() {
        return FRESH_VEGETABLES;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + FRESH_VEGETABLES_PRICE;
        System.out.println(FRESH_VEGETABLES + " - " + FRESH_VEGETABLES_PRICE + " Euro");
        return price;
    }

}
