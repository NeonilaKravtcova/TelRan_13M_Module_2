package de.telran;

abstract class Shape {

    static final String RESET = "\u001B[0m";
    static final String BLACK = "\u001B[30m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BACKGROUND_WHITE = "\u001B[37m";
    static final String BACKGROUND_BLACK = "\u001B[40m";
    static final String BACKGROUND_RED = "\u001B[41m";
    static final String BACKGROUND_GREEN = "\u001B[42m";
    static final String BACKGROUND_BLUE = "\u001B[46m";

    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();

}
