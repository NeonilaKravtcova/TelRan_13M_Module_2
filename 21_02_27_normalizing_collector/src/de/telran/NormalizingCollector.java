package de.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NormalizingCollector implements Collector<Integer, List<Integer>, List<Double>> {
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
    public Function<List<Integer>, List<Double>> finisher() {
        return numbers -> {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);

            return numbers
                    .stream()
                    .map(number -> ((double) number - min) / (max - min))
                    .collect(Collectors.toList())
                    ;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
        //return EnumSet.of(Characteristics.CONCURRENT);
    }
}
