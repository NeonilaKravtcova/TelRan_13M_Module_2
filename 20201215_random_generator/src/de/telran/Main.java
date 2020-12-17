package de.telran;

import de.telran.generator.RandomGenerator;
import de.telran.generator.RandomRule;
import de.telran.generator.rule.ListRandomRule;
import de.telran.generator.rule.RangeRandomRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, -5, 15));

        int[] ints = new int[]{8, -5, 15};

        RandomRule rule0 = new RangeRandomRule(3);

        RandomRule rule1 = new ListRandomRule(list){};

        RandomRule rule2 = new ListRandomRule(ints);

        RandomGenerator generator0 = new RandomGenerator(rule0);
        RandomGenerator generator1 = new RandomGenerator(rule1);
        RandomGenerator generator2 = new RandomGenerator(rule2);


        List<Integer> res = generator0.nextInts(6);
        System.out.println(res);
        frequencyCounter(res);

        res = generator1.nextInts(9);
        System.out.println(res);
        frequencyCounter(res);

        res = generator2.nextInts(9);
        System.out.println(res);
        frequencyCounter(res);

    }

    private static void frequencyCounter(List<Integer> list){
        for (int i = Collections.min(list); i <= Collections.max(list); i++) {
            int count = Collections.frequency(list, i);
            if (count >= 1) {
                System.out.print(i + " - ");
                System.out.printf(("%.2f"), (double) count / list.size());
                System.out.println("%");
            }
        }
        System.out.println();
    }
}
