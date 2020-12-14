package de.telran;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //ArrayList strings = new ArrayList();
        //List strings = new ArrayList();

        OurArrayList<String> strings;
        strings = fillArray(5);

        //downcasting
        //ArrayList anotherString = (ArrayList) strings;

        strings.addLast("Vasya");
        strings.addLast("Petya");

        //Iterator<String> forwardIterator = strings.forwardIterator();

        iterate(strings.forwardIterator());

        System.out.println();

        iterate(strings.backwardIterator());


/*        String str1 = strings.get(0);
        String str2 = strings.get(1);

        String res = "";

        for (int i = 0; i < strings.size(); i++) {
            res += strings.get(i);
        }*/

        System.out.println();

        //Iterable
/*        for (String s : strings) {
            System.out.println(s);
        }*/

        //equivalent to:
/*        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()){
            String str = stringIterator.next();
            System.out.println(str);
        }*/

        //--------- HOMEWORK 13.12.2020 ------------//
        OurLinkedList<String> strings1 = fillLinkedList(10);
        outPrintLikedList(strings1);
        System.out.println(strings1.get(9));

        strings1.removeById(9);
        System.out.println(strings1.get(8));

        System.out.println(strings1.get(4));
        strings1.removeById(4);
        System.out.println(strings1.get(4));

        System.out.println(strings1.get(0));
        System.out.println(strings1.get(strings1.size() - 1));
        System.out.println();

        for (int i = 0; i < strings1.size(); i++) {
            System.out.print(strings1.get(i));
        }

        System.out.println();
        System.out.println();

        strings1 = fillLinkedList(5);
        outPrintLikedList(strings1);

        strings1.removeById(strings1.size() - 1);
        outPrintLikedList(strings1);

        strings1.removeById(3);
        outPrintLikedList(strings1);

        strings1.removeById(2);
        outPrintLikedList(strings1);

        strings1.removeById(1);
        outPrintLikedList(strings1);

        strings1.removeById(0);
        outPrintLikedList(strings1);

        strings1.addLast("Vasya");
        strings1.removeById(0);
        outPrintLikedList(strings1);

        OurLinkedList<Integer> integers = new OurLinkedList<>(null, null, 0);
        integers.addLast(5);
        integers.addLast(-10);
        integers.addLast(0);
        integers.addLast(8);
        integers.addLast(15);

        outPrintInteger(integers);

        integers.removeById(4);
        outPrintInteger(integers);

        integers.removeById(3);
        outPrintInteger(integers);

        integers.removeById(2);
        outPrintInteger(integers);

        integers.removeById(1);
        outPrintInteger(integers);

        integers.removeById(0);
        outPrintInteger(integers);


        OurLinkedList<String> strings2 = fillLinkedList(10);
        outPrintLikedList(strings2);

        strings2.clear();
        outPrintLikedList(strings2);


        strings2 = fillLinkedList(5);
        System.out.println(strings2.remove("-2-"));
        outPrintLikedList(strings2);

        System.out.println(strings2.remove("-6-"));
        outPrintLikedList(strings2);

        strings2.clear();
        strings2.addLast("LL");
        outPrintLikedList(strings2);

        System.out.println(strings2.removeById(0));
        outPrintLikedList(strings2);

        System.out.println(strings2.remove(""));
        System.out.println(strings2.remove(null));
        System.out.println(strings2.remove("LL"));

        strings2 = fillLinkedList(5);
        System.out.println(strings2.contains("-4-"));
        System.out.println(strings2.contains("-7-"));
        System.out.println(strings2.contains(null));
        strings2.set(2, null);
        outPrintLikedList(strings2);
        System.out.println(strings2.contains(null));

    }

    static void iterate(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }

    static void outPrint(OurArrayList<String> ourArrayList){
        System.out.println("size: " + ourArrayList.size() + "   ");
        if (ourArrayList.size() == 0){
            System.out.println("OurArrayList is empty");
        } else {
            for (int i = 0; i < ourArrayList.size(); i++) {
                System.out.print(ourArrayList.get(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    static void outPrintLikedList(OurLinkedList<String> ourLinkedList){
        System.out.println("size: " + ourLinkedList.size() + "   ");
        if (ourLinkedList.size() == 0){
            System.out.println("LinkedListArray is empty");
        } else {
            for (int i = 0; i < ourLinkedList.size(); i++) {
                System.out.print(ourLinkedList.get(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    static void outPrintInteger(OurLinkedList<Integer> ourLinkedList){
        System.out.println("size: " + ourLinkedList.size() + "   ");
        if (ourLinkedList.size() == 0){
            System.out.println("LinkedListArray is empty");
        } else {
            for (int i = 0; i < ourLinkedList.size(); i++) {
                System.out.print(ourLinkedList.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static OurArrayList<String> fillArray(int size){
        OurArrayList<String> output = new OurArrayList<>();
        for (int i = 0; i < size; i++) {
            output.addLast("-" + i + "-");
        }
        return output;
    }

    static OurLinkedList<String> fillLinkedList(int size){
        OurLinkedList<String> output = new OurLinkedList<>(null, null, 0);
        for (int i = 0; i < size; i++) {
            output.addLast("-" + i + "-");
        }
        return output;
    }


}



