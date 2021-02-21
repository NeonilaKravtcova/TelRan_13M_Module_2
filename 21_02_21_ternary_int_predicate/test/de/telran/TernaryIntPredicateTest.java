package de.telran;

import org.junit.Assert;
import org.junit.Test;

public class TernaryIntPredicateTest {

    TernaryIntPredicate predicate = new TernaryIntPredicate();

    @Test
    public void test_allNumbersPairwiseNonIdentical(){
        Assert.assertTrue(predicate.test(1, 2, 4));
        Assert.assertTrue(predicate.test(-5, 0, 12));
    }

    @Test
    public void test_allNumbersPairwiseIdentical(){
        Assert.assertFalse(predicate.test(2, 2, 2));
    }

    @Test
    public void test_aEqualsB_BNotEqualsC(){
        Assert.assertFalse(predicate.test(2, 2, 4));
    }

    @Test
    public void test_aEqualsC_BNotEqualsC(){
        Assert.assertFalse(predicate.test(4, 2, 4));
    }

    @Test
    public void test_aNotEqualsB_BEqualsC(){
        Assert.assertFalse(predicate.test(2, 4, 4));
    }

}
