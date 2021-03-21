package de.telran.entity;

public abstract class Shape {

    static final String RESET = "\u001B[0m";
    static final String BLACK = "\u001B[30m";

    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();
}
