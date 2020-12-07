package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator implements Iterator<Integer> {

    private final int[] arrayToIterate;
    private int currentIndex = 0;

    SimpleArrayIterator(int[] arrayToIterate){
        this.arrayToIterate = arrayToIterate;
    }

    //hasNext у нас консистентная операция, так как мы ничего не двигаем с её помощью
    @Override
    public boolean hasNext() {
        return currentIndex < arrayToIterate.length;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        //return arrayToIterate[currentIndex++];
        int res = arrayToIterate[currentIndex];
        currentIndex++;
        return res;
    }


}
