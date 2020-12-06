package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //ArrayList strings = new ArrayList();
        //List strings = new ArrayList();

        OurArrayList<String> strings = new OurArrayList<>();

        //downcasting
        //ArrayList anotherString = (ArrayList) strings;

        strings.addLast("Vasya");
        //strings.add(4);
        //strings.addLast(Integer.valueOf(4));
        strings.addLast("");

        String str1 = (String) strings.get(0);
        String str2 = (String) strings.get(1);

        String res = "";

        for (int i = 0; i < strings.size(); i++) {
            res += strings.get(i);
        }

    }
}



