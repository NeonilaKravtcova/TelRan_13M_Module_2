package de.telran;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //ArrayList strings = new ArrayList();
        //List strings = new ArrayList();

        OurArrayList<String> strings = new OurArrayList<>();
        strings = fillArray(5);

        //downcasting
        //ArrayList anotherString = (ArrayList) strings;

        strings.addLast("Vasya");
        strings.addLast("Petya");

        //Iterator<String> forwardIterator = strings.forwardIterator();

        iterate(strings.forwardIterator());

        System.out.println();

        iterate(strings.backwardIterator());


        String str1 = strings.get(0);
        String str2 = strings.get(1);

        String res = "";

        for (int i = 0; i < strings.size(); i++) {
            res += strings.get(i);
        }


    }

    static void iterate(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }

    static OurArrayList<String> fillArray(int size){
        OurArrayList<String> output = new OurArrayList<>();
        for (int i = 0; i < size; i++) {
            output.addLast(String.valueOf(i));
        }
        return output;
    }


}



