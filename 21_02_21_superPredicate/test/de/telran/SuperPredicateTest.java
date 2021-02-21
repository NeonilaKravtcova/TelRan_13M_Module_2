package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class SuperPredicateTest {

    IntPredicate pred1 = x -> x > 3;
    IntPredicate pred2 = x -> x % 2 == 0;
    IntPredicate pred3 = x -> x < 10;
    IntPredicate pred4 = x -> x * 5 >= 20 && x * 5 <=30;

    List<IntPredicate> predicates = new ArrayList(Arrays.asList(pred1, pred2, pred3, pred4));

    SuperPredicate superPredicate = new SuperPredicate();

    IntPredicate super1 = superPredicate.intersect(predicates);

    @Test
    public void intersect_rangeFrom1To10Test(){
        Assert.assertFalse(super1.test(1));
        Assert.assertFalse(super1.test(2));
        Assert.assertFalse(super1.test(3));
        Assert.assertTrue(super1.test(4));
        Assert.assertFalse(super1.test(5));
        Assert.assertTrue(super1.test(6));
        Assert.assertFalse(super1.test(7));
        Assert.assertFalse(super1.test(8));
        Assert.assertFalse(super1.test(9));
        Assert.assertFalse(super1.test(10));
    }
}
