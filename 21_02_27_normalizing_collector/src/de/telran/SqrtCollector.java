package de.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SqrtCollector implements Collector<Integer, List<Integer>, Double> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (currentRes, currentList) -> {
            currentRes.addAll(currentList);
            return currentRes;
        };
    }

    @Override
    public Function<List<Integer>, Double> finisher() {
        return numbers ->
             Math.sqrt(numbers
                    .stream()
                    .mapToDouble(number -> ((double) number * number))
                    .sum() / numbers.size());
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
        //return EnumSet.of(Characteristics.CONCURRENT);
    }
}
