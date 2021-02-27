package de.telran;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class SqrService {

    public int sumSqr(List<Integer> numbers) {
        return numbers
                .stream()
                .collect(Collectors.summingInt(x -> x * x));
        //.mapToInt(x -> x * x).sum();
    }

    public int multiplySqr(List<Integer> numbers) {
        return numbers
                .stream()
                .collect(reducing(1, x -> x, (x, y) -> x * y * y));
        //.mapToInt(x -> x * x)
        //.reduce((x, y) -> x * y)
        //.getAsInt();
    }

/*    public long multiplicationSquared(List<Integer> numbers) {
        return numbers.stream()
                .collect(reducing(1L,
                        numberInt -> numberInt.longValue(),
                        (currentRes, currentNum) -> currentRes * currentNum * currentNum));
    }*/
}
