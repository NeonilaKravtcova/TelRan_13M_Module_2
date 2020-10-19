package de.telran.decorator;

public class CannedVegetablesDecorator extends AbstractDecorator {
    private final static String CANNED_VEGETABLES = "Canned vegetables";
    private final static double CANNED_VEGETABLES_PRICE = 1.30;

    public CannedVegetablesDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return CANNED_VEGETABLES;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + CANNED_VEGETABLES_PRICE;
        System.out.println(CANNED_VEGETABLES + " - " + CANNED_VEGETABLES_PRICE + " Euro");
        return price;
    }
}
