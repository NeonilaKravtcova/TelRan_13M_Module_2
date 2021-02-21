package de.telran;

import java.util.List;
import java.util.function.IntPredicate;

public class SuperPredicate {

    public IntPredicate intersect(List<IntPredicate> predicateList){
        IntPredicate res = predicateList.get(0);
        for (int i = 1; i < predicateList.size(); i++) {
            res = res.and(predicateList.get(i));
        }
        return res;
    }
}
