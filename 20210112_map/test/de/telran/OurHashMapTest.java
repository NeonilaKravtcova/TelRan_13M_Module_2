package de.telran;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Tatiana", map.put(1, "Tatiana"));
        assertEquals("Olga", map.put(1, "Olga"));
    }

    @Test
    public void putDifferentPairs_testGetValues(){
        assertThrows(NullPointerException.class, ()-> map.get(10));
        map.put(1, "Olga");
        assertEquals("Olga", map.get(1));
        for (int i = 0; i < 12; i++) {
            map.put(i, "0" + i);
        }
        assertEquals("05", map.get(5));
        assertEquals("011", map.get(11));
        assertThrows(NullPointerException.class, ()-> map.get(12));
    }

    @Test
    public void removeByKey_test(){
        map.put(1, "Olga");
        map.put(2, "Tatiana");
        assertEquals("Tatiana", map.remove(2));
    }

}
