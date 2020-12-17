package de.telran.generator.rule;

import de.telran.generator.RandomRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements RandomRule {

    private List<Integer> values;
    private Random random = new Random();

    public ListRandomRule(List<Integer> values) {
        this.values = values;
    }

    public ListRandomRule(int[] numbers){
        List<Integer> list = new ArrayList<>(numbers.length);
        for (int number : numbers) {
            list.add(number);
        }
        this.values = list;
    }

    @Override
    public int nextInt(){
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
