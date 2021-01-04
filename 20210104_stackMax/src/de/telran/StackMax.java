package de.telran;

import java.util.Deque;

public class StackMax {

    private Deque<Integer> source;

    public StackMax(Deque<Integer> source) {
        this.source = source;
    }

    public void addLast(int elt) {
        source.addLast(elt);
    }

    public int getLast() {
        return source.getLast();
    }

    public int removeLast() {
        if (source.isEmpty()){
            throw new EmptyDequeException();
        }
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
        if (source.isEmpty()){
            return 0;
        }
        int max = source.getFirst();
        for (int elt : source) {
            if (max < elt){
                max = elt;
            }
        }
        return max;
    }
}