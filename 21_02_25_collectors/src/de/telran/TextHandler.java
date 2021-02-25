package de.telran;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextHandler {

    List<String> list;

    public TextHandler(List<String> list) {
        this.list = list;
    }

    public Map palindromFilter(){
        Predicate<String> predicate = str -> str.equals(new StringBuilder(str).reverse().toString());
        return list
                .stream()
                .collect(Collectors.partitioningBy(predicate));
    }
}
