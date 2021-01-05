package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMax {

    private final Deque<Integer> source;
    private final Deque<Integer> currentMax;

    public StackMax() {
        source = new ArrayDeque<>();
        currentMax = new ArrayDeque<>();

    }

    public void addLast(int elt) {
        source.addLast(elt);

        if (source.size() == 1) {
            currentMax.addLast(elt);
        } else if (elt >= currentMax.getLast()) {
            currentMax.addLast(elt);
        } else {
            int max = currentMax.getLast();
            currentMax.addLast(max);
        }
    }

    public int getLast() {
        if (source.isEmpty()) {
            throw new EmptyDequeException();
        }
        currentMax.getLast();
        return source.getLast();
    }

    public int removeLast() {
        if (source.isEmpty()) {
            throw new EmptyDequeException();
        }
        currentMax.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
        if (source.isEmpty()) {
            throw new EmptyDequeException();
        }
        return currentMax.getLast();
    }
}