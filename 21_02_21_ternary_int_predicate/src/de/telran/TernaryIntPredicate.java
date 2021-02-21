package de.telran;

public class TernaryIntPredicate implements IntPredicate {

    int a;
    int b;
    int c;

    @Override
    public boolean test(int a, int b, int c) {
        return (a != b) && (b != c) && (a != c);
    }

}
