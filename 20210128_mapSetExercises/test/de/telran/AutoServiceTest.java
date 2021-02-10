package de.telran;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AutoServiceTest {

    Auto auto1 = new Auto("Mercedes", Colors.RED);
    Auto auto2 = new Auto("Volkswagen", Colors.YELLOW);
    Auto auto3 = new Auto("Mercedes", Colors.BLUE);
    Auto auto4 = new Auto("Volkswagen", Colors.ORANGE);
    Auto auto5 = new Auto("Mercedes", Colors.BLACK);
    Auto auto6 = new Auto("Jeep", Colors.BLACK);
    Auto auto7 = new Auto("Volkswagen", Colors.ROSE);
    Auto auto8 = new Auto("Jeep", Colors.GREEN);
    Auto auto9 = new Auto("Ford Ranger", Colors.WHITE);

    Exercises exercise = new Exercises();
    Map<String, List<Auto>> map = new HashMap();
    List<Auto> autos = new ArrayList<>();

    @Test
    public void testGroupByMake_size_of_generated_map() {
        autos.add(auto1);
        autos.add(auto3);
        assertEquals(1, exercise.groupByMake(autos).size());
        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);
        assertEquals(2, exercise.groupByMake(autos).size());
        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);
        autos.add(auto4);
        autos.add(auto6);
        assertEquals(3, exercise.groupByMake(autos).size());
        autos.add(auto9);
        assertEquals(4, exercise.groupByMake(autos).size());
    }

    @Test
    public void test_groupByMake_CorrectKeys() {
        Collections.addAll(autos, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9);
        Map<String, List<Auto>> res = exercise.groupByMake(autos);
        HashSet<String> resKeys = new HashSet<>();
        resKeys.add("Mercedes");
        resKeys.add("Volkswagen");
        resKeys.add("Jeep");
        resKeys.add("Ford Ranger");
        assertEquals(resKeys, res.keySet());
    }

    @Test
    public void test_groupByMake_CorrectValues_Mercedes() {
        Collections.addAll(autos, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9);
        Map<String, List<Auto>> res = exercise.groupByMake(autos);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, auto1, auto3, auto5);
        assertEquals(expValues, res.get("Mercedes"));
    }

    @Test
    public void test_groupByMake_CorrectValues_Volkswagen() {
        Collections.addAll(autos, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9);
        Map<String, List<Auto>> res = exercise.groupByMake(autos);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, auto2, auto4, auto7);
        assertEquals(expValues, res.get("Volkswagen"));
    }

    @Test
    public void test_groupByMake_CorrectValues_Jeep() {
        Collections.addAll(autos, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9);
        Map<String, List<Auto>> res = exercise.groupByMake(autos);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, auto6, auto8);
        assertEquals(expValues, res.get("Jeep"));
    }

    @Test
    public void test_groupByMake_CorrectValues_Ford() {
        Collections.addAll(autos, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9);
        Map<String, List<Auto>> res = exercise.groupByMake(autos);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, auto9);
        assertEquals(expValues, res.get("Ford Ranger"));
    }

}
