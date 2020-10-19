package de.telran.controller;

import de.telran.decorator.*;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBase();
        pizza.getPrice();
        System.out.println();

        Pizza pizza1 = new SauceDecorator(pizza);
        System.out.println(pizza1.toString());

        Pizza pizza2 = (new FreshVegetablesDecorator(new SauceDecorator(new PizzaBase())));
        System.out.println(pizza2.toString());

        System.out.println(new FreshVegetablesDecorator(new PizzaBase()));

        System.out.println(new CannedVegetablesDecorator(new FreshVegetablesDecorator(new SauceDecorator(new PizzaBase()))));

        System.out.println(new FruitsDecorator(pizza));

        System.out.println(new CheeseDecorator(pizza2));

        System.out.println(new MeatDecorator(new SeaFoodsDecorator(new FreshVegetablesDecorator(new SauceDecorator(new CheeseDecorator(new PizzaBase()))))));

    }
}
