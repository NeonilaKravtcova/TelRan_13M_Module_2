package de.telran;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OurHashMapTest {

    OurHashMap<Integer, String> map = new OurHashMap<>();

    @Test
    public void putOnePairToMap_testSizeKeyValue(){
        assertEquals("Olga", map.put(1, "Olga"));
        assertEquals(1, map.size());
    }

    @Test
    public void putSomePairs_testSizeAndResize(){
        assertEquals(0, map.size());
        for (int i = 0; i < 12; i++) {
            map.put(i, "0" + i);
        }
        assertEquals(12, map.size());
        map.put(12, "121212");
        assertEquals(13, map.size());
        for (int i = 13; i < 24; i++) {
            map.put(i, "0" + i);
        }
        assertEquals(24, map.size());
    }

    @Test
    public void putDifferentValuesForSameKeys_testOverride(){
        map.put(1, "Olga");
        assertEquals("Olga", map.put(1, "Tatiana"));
        assertEquals("Tatiana", map.put(1, "Olga"));
    }

    @Test
    public void putDifferentPairs_testGetValues(){
        assertNull(map.get(10));
        map.put(1, "Olga");
        assertEquals("Olga", map.get(1));
        for (int i = 0; i < 12; i++) {
            map.put(i, "0" + i);
        }
        assertEquals("05", map.get(5));
        assertEquals("011", map.get(11));
        assertNull(map.get(12));
    }

    @Test
    public void removeByKey_test(){
        map.put(1, "Olga");
        map.put(2, "Tatiana");
        assertEquals("Olga", map.remove(1));
        assertEquals("Tatiana", map.remove(2));
    }

    Map<Auto, String> mapAuto = new HashMap<>();
    Auto auto1 = new Auto("Grey", "Opel");
    Auto auto2 = new Auto("Red", "Mazda");
    Auto auto3 = new Auto("Yellow", "Mercedes");
    Auto auto4 = new Auto("Blue", "Volkswagen");


    @Test
    public void putOnePairToMap_tes2SizeKeyValue1(){
        assertEquals(0, map.size());
        mapAuto.put(auto1, "Owner: Olga");
        //assertEquals("Owner: Olga", mapAuto.put(auto1, "Owner: Olga"));
        //assertEquals(1, map.size());
    }




}
