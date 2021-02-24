package de.telran;

import java.util.List;
import java.util.function.IntPredicate;

public class SuperPredicate {

    public IntPredicate intersect(List<IntPredicate> predicateList){
        //IntPredicate res = predicateList.get(0);
        IntPredicate res = x -> true;
/*        for (int i = 1; i < predicateList.size(); i++) {
            res = res.and(predicateList.get(i));//Скорость доступа к элементу под номером n в LinkedList = O(n)
        }*/
        for (IntPredicate predicate : predicateList) {
            res = res.and(predicate);
        }
        return res;
    }
}
