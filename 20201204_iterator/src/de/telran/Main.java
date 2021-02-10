package de.telran;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int[] array = {10, -8, 0, 15};

        Iterator<Integer> simpleArrayIterator = new SimpleArrayIterator(array);
        //Можно и так написать
        //SimpleArrayIterator simpleArrayIterator = new SimpleArrayIterator(array);

        //В этих строчках нет ни слова про массив. Мы пользуемся паттерном, который строится на основе контейнера
        while (simpleArrayIterator.hasNext()){
            int current = simpleArrayIterator.next();
            System.out.print(current + "  ");
        }

        System.out.println();

        BackwardArrayIterator backwardsArrayIterator = new BackwardArrayIterator(array, array.length);

        while (backwardsArrayIterator.hasPrev()){
            System.out.print(backwardsArrayIterator.prev() + "  ");
        }


    }
}
