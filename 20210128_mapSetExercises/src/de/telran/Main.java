package de.telran;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Integer> list1 = Arrays.asList(1, 1, 2, 1);
        List<Integer> list2 = Arrays.asList(6, 6, 5, 3, 6);
        List<Integer> list3 = Arrays.asList(0, 0, 0, 0, null, -1);

        Exercises exercise = new Exercises();
        System.out.println(exercise.listToSet(list1));
        System.out.println(exercise.listToSet(list2));
        System.out.println(exercise.listToSet(list3));
        System.out.println();

        Auto auto1 = new Auto("Mercedes", Colors.RED);
        Auto auto2 = new Auto("Volkswagen", Colors.YELLOW);
        Auto auto3 = new Auto("Mercedes", Colors.BLUE);
        Auto auto4 = new Auto("Volkswagen", Colors.ORANGE);
        Auto auto5 = new Auto("Mercedes", Colors.BLACK);
        Auto auto6 = new Auto("Jeep", Colors.BLACK);
        Auto auto7 = new Auto("Volkswagen", Colors.ROSE);
        Auto auto8 = new Auto("Jeep", Colors.GREEN);
        Auto auto9 = new Auto("Ford Ranger", Colors.WHITE);


        exercise.groupByMake(Arrays.asList(auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9));

    }

}
