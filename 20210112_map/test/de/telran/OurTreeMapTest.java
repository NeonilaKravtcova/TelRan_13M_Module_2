package de.telran;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

public class OurTreeMapTest {

    OurTreeMap<Integer, String> ourTreeMap = new OurTreeMap();

    @Test
    public void put_test() {
        assertNull(ourTreeMap.put(5, "05"));
        assertEquals("05", ourTreeMap.put(5, "00"));
        assertNull(ourTreeMap.put(10, "10"));
        assertEquals("10", ourTreeMap.put(10, "1010"));
    }

    @Test
    public void putAndRemove_test(){
        OurTreeMap<Integer, String> ourTreeMap = new OurTreeMap();
        ourTreeMap.put(10, "ten");
        assertEquals("ten", ourTreeMap.get(10));
        assertEquals(1, ourTreeMap.size());
        ourTreeMap.put(5, "five");
        assertEquals("five", ourTreeMap.get(5));
        assertEquals(2, ourTreeMap.size());
        ourTreeMap.put(15, "fifteen");
        assertEquals("fifteen", ourTreeMap.get(15));
        assertEquals(3, ourTreeMap.size());
        ourTreeMap.put(12, "twelve");
        assertEquals("twelve", ourTreeMap.get(12));
        ourTreeMap.put(11, "eleven");
        ourTreeMap.put(13,"thirteen");
        ourTreeMap.put(20, "twenty");
        ourTreeMap.put(18,"eighteen");
        ourTreeMap.put(19, "nineteen");
        assertEquals("eleven", ourTreeMap.get(11));
        assertEquals("thirteen", ourTreeMap.get(13));
        assertEquals("twenty", ourTreeMap.get(20));
        assertEquals("eighteen", ourTreeMap.get(18));
        assertEquals("nineteen", ourTreeMap.get(19));
        assertEquals(9, ourTreeMap.size());

/*        assertEquals("ten", ourTreeMap.remove(10));
        assertEquals(8, ourTreeMap.size());
        assertNull(ourTreeMap.get(10));*/

        assertEquals("five", ourTreeMap.remove(5));
        assertEquals(8, ourTreeMap.size());
        assertNull(ourTreeMap.get(5));

        assertEquals("eleven", ourTreeMap.remove(11));
        assertEquals(7, ourTreeMap.size());
        assertNull(ourTreeMap.get(11));
        assertEquals("thirteen", ourTreeMap.get(13));
        assertEquals("nineteen", ourTreeMap.get(19));

        assertEquals("twelve", ourTreeMap.remove(12));
        assertEquals(6, ourTreeMap.size());
        assertNull(ourTreeMap.get(12));

        assertEquals("thirteen", ourTreeMap.remove(13));
        assertEquals(5, ourTreeMap.size());
        //assertNull(ourTreeMap.get(13));

        assertEquals("eighteen", ourTreeMap.remove(18));
        assertEquals(4, ourTreeMap.size());
        assertNull(ourTreeMap.get(18));


    }


}
