package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIterator implements Iterator {

    private final int[] arrayToIterate;
    private int currentIndex;

    public BackwardArrayIterator(int[] arrayToIterate, int currentIndex) {
        this.arrayToIterate = arrayToIterate;
        this.currentIndex = arrayToIterate.length;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public boolean hasPrev() {
        return currentIndex > 0;
    }

    public Integer prev() {
        if (!hasPrev()) {
            throw new NoSuchElementException();
        }
        return arrayToIterate[--currentIndex];
    }


}


