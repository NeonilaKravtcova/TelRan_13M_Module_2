package de.telran;

import java.util.List;
import java.util.stream.Collectors;

public class Sqrt {

    List<Integer> list;

    public Sqrt(List<Integer> list) {
        this.list = list;
    }

    public int sumSqrt(){
        return list
                .stream()
                .collect(Collectors.summingInt(x -> x * x));
                //.mapToInt(x -> x * x).sum();
    }

    public int multiplySqrt(){
        return list
                .stream()
                .mapToInt(x -> x * x)
                .reduce((x, y) -> x * y)
                .getAsInt();
    }
}
