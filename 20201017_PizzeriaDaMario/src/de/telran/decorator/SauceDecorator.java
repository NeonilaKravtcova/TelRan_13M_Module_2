package de.telran.decorator;

public class SauceDecorator extends AbstractDecorator {
    private static final String BASIC_SAUCE = "Tomato sauce";
    private static final double BASIC_SAUCE_PRICE = 0.5;

    public SauceDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getName() {
        return BASIC_SAUCE;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + BASIC_SAUCE_PRICE;
        System.out.println(BASIC_SAUCE + " - " + BASIC_SAUCE_PRICE + " Euro");
        //System.out.println("-----------------------\nTotal price: " + price + " Euro\n");
        return price;
    }

/*    @Override
    public String toString() {
        return "-----------------------\nTotal price: " + getPrice() + " Euro\n";
    }*/
}
