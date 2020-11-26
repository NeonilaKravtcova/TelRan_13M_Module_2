package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        //int[] array = new int[10];
        //System.out.println(array[10]);

        List<Integer> list = new ArrayList<>();

        try {
            list.get(10);
        } catch (IndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("After try");
    }
}
