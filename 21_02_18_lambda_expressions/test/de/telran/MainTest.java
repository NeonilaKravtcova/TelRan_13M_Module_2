package de.telran;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void init() {
        Integer a = 2;
        Integer b = 3;
        Integer c = 4;
    }

    @Test
    void removeDuplicatesOperator_test() {
        UnaryOperator<List<String>> removeDuplicatesOperator = list -> new ArrayList<>(new LinkedHashSet<>(list));
        List<String> list = Arrays.asList("A", "B", "C", "A", "D", "C", "A");
        List<String> res = Arrays.asList("A", "B", "C", "D");

        assertEquals(res, removeDuplicatesOperator.apply(list));
    }

    @Test
    void function_test_cases_1_2_10() {
        int a = 2;
        int b = 3;
        int c = 4;
        Function<Integer, Integer> function = x -> a * x * x + b * x + c;

        assertEquals(9, function.apply(1));
        assertEquals(18, function.apply(2));
        assertEquals(234, function.apply(10));
    }

    @Test
    void operator_test_cases_1_2_10() {
        int a = 2;
        int b = 3;
        int c = 4;
        IntUnaryOperator operator = x -> a * x * x + b * x + c;

        assertEquals(9, operator.applyAsInt(1));
        assertEquals(18, operator.applyAsInt(2));
        assertEquals(234, operator.applyAsInt(10));
    }

}
