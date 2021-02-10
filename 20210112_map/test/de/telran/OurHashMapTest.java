package de.telran;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class OurHashMapTest {

    OurHashMap<Integer, String> map1 = new OurHashMap<>();

    OurHashMap<Auto, String> mapAuto = new OurHashMap<>();

    Auto auto1 = new Auto("Opel", "Grey");
    Auto auto2 = new Auto("Mazda", "Red");
    Auto auto3 = new Auto("Mercedes", "Orange");
    Auto auto4 = new Auto("Volkswagen", "Yellow");
    Auto auto5 = new Auto("Lada", "Green");
    Auto auto6 = new Auto("Ford", "Blue");
    Auto auto7 = new Auto("Toyota", "Lila");
    Auto auto8 = new Auto("Toyota", "Rose");
    Auto auto9 = new Auto("Toyota", "Black");
    Auto auto10 = new Auto("Toyota", "White");

    @Test
    public void putOnePairChangeValues_testSizeAndValues(){
        assertEquals(0, mapAuto.size());
        assertNull(mapAuto.put(auto1, "Olga"));
        assertEquals(1, mapAuto.size());
        assertEquals("Olga", mapAuto.put(auto1, "Tatiana"));
        assertEquals(1, mapAuto.size());
        assertEquals("Tatiana", mapAuto.put(auto1, "Alexandr"));
        assertEquals(1, mapAuto.size());
    }

    @Test
    public void putSomePairs_testSizeAndValues(){
        assertEquals(0, mapAuto.size());

        assertNull(mapAuto.put(auto1, "auto1"));
        assertEquals(1, mapAuto.size());
        assertEquals("auto1", mapAuto.get(auto1));

        assertNull(mapAuto.put(auto2, "auto2"));
        assertEquals(2, mapAuto.size());
        assertEquals("auto2", mapAuto.get(auto2));

        assertNull(mapAuto.put(auto3, "auto3"));
        assertEquals(3, mapAuto.size());
        assertEquals("auto3", mapAuto.get(auto3));

        assertNull(mapAuto.put(auto4, "auto4"));
        assertEquals(4, mapAuto.size());
        assertEquals("auto4", mapAuto.get(auto4));
        assertEquals("auto2", mapAuto.get(auto2));
        assertEquals("auto1", mapAuto.get(auto1));

        assertEquals("auto3", mapAuto.get(auto3));

        assertNull(mapAuto.put(auto5, "auto5"));
        assertEquals(5, mapAuto.size());
        assertEquals("auto5", mapAuto.get(auto5));
        assertNull(mapAuto.put(auto6, "auto6"));
        assertEquals(6, mapAuto.size());
        assertNull(mapAuto.put(auto7, "auto7"));
        assertEquals(7, mapAuto.size());
        assertNull(mapAuto.put(auto8, "auto8"));
        assertEquals(8, mapAuto.size());
        assertNull(mapAuto.put(auto9, "auto9"));
        assertEquals(9, mapAuto.size());
        assertNull(mapAuto.put(auto10, "auto10"));
        assertEquals(10, mapAuto.size());
        assertEquals("auto5", mapAuto.get(auto5));

        assertEquals("auto1", mapAuto.get(auto1));
        assertEquals("auto2", mapAuto.get(auto2));
        assertEquals("auto3", mapAuto.get(auto3));
        assertEquals("auto4", mapAuto.get(auto4));
        assertEquals("auto5", mapAuto.get(auto5));
        assertEquals("auto6", mapAuto.get(auto6));
        assertEquals("auto7", mapAuto.get(auto7));
        assertEquals("auto8", mapAuto.get(auto8));
        assertEquals("auto9", mapAuto.get(auto9));
        assertEquals("auto10", mapAuto.get(auto10));

        assertEquals("auto8", mapAuto.remove(auto8));
        assertNull(mapAuto.get(auto8));
        assertEquals(9, mapAuto.size());

        assertEquals("auto5", mapAuto.get(auto5));

        assertEquals("auto9", mapAuto.get(auto9));
        assertEquals("auto5", mapAuto.remove(auto5));
        assertEquals("auto9", mapAuto.remove(auto9));
        assertEquals(7, mapAuto.size());

    }

    @Test
    public void putOnePairToMap_testSizeAndValue(){
        assertNull(map1.put(1, "Olga"));
        assertEquals(1, map1.size());
    }

    @Test
    public void putSomePairs_testSizeAndResize(){
        assertEquals(0, map1.size());

        for (int i = 0; i < 12; i++) { map1.put(i, "0" + i);}
        assertEquals(12, map1.size());

        map1.put(12, "121212");
        assertEquals(13, map1.size());

        for (int i = 13; i < 33; i++) {
            map1.put(i, "0" + i);
        }
        assertEquals(33, map1.size());
    }


    @Test
    public void putDifferentValuesForSameKey_testPut(){
        map1.put(1, "Olga");
        assertEquals("Olga", map1.put(1, "Tatiana"));
        assertEquals("Tatiana", map1.put(1, "Olga"));
    }

    @Test
    public void putDifferentPairs_testGetValues(){
        assertNull(map1.get(10));
        map1.put(1, "Olga");
        assertEquals("Olga", map1.get(1));
        for (int i = 1; i < 50; i++) {
            map1.put(i, "0" + i);
            assertEquals("0" + i, map1.get(i));
        }
    }

    @Test
    public void removeByKey_test(){
        map1.put(1, "Olga");
        map1.put(2, "Tatiana");
        assertEquals("Olga", map1.remove(1));
        assertEquals("Tatiana", map1.remove(2));
    }

    OurHashMap<String, Auto> map = new OurHashMap<>();

    @Test
    public void testPut_resize() {
        OurHashMap<String, Auto> map = new OurHashMap<>(0.5);
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.get("WIN56256"), audi2);
        assertEquals(9, map.size());
    }

    @Test
    public void changeTheValueOofAnExistingElement() {

        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertNotSame(map.get("WIN5628"), audi);
        assertEquals(1, map.size());
    }

    @Test
    public void testRemove_twoObjectInCells_bottom() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.remove("WIN8989"), bmw);
        assertEquals(map.get("WIN74528"), opel);
        assertEquals(8, map.size());
        String[] autoWin={"WIN4528","WIN56828","WIN74528","WIN56628","WIN56298","WIN8988","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }

    @Test
    public void testRemove_OneElement(){
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);

        assertEquals(map.remove("WIN8988"), bmw);
        assertThrows(NoSuchElementException.class, () -> map.get("WIN8988"));
        assertEquals(8, map.size());
        String[] autoWin={"WIN4528","WIN56828","WIN74528","WIN56628","WIN56298","WIN8989","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }
    @Test
    public void testRemove_twoObjectInCells_UpElement() {
        OurHashMap<String, Auto> map = new OurHashMap<>();
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.remove("WIN74528"), opel);
        assertEquals(map.get("WIN8989"), bmw);
        assertEquals(8, map.size());

        String[] autoWin={"WIN4528","WIN56828","WIN56628","WIN56298","WIN8988","WIN8989","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }

    @Test
    public void put_changeElement() {

        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto bmw1 = new Auto("pink", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN8988", bmw);
        map.put("WIN8988", bmw1);
        assertEquals(map.get("WIN8988"), bmw1);
        assertNotSame(map.get("WIN8988"), bmw);


        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertNotSame(map.get("WIN5628"), audi);
        assertEquals(7, map.size());

        String[] autoWin={"WIN4528","WIN56828","WIN74528","WIN56628","WIN56298","WIN8988","WIN5628"};
        checkAllElements(map,autoWin);
    }

    public void checkAllElements(OurHashMap<String, Auto> mapCheck,String[] arrayStr){
        for (String elm:arrayStr) {
            // System.out.println(elm);
            assertTrue(mapCheck.get(elm)!=null);
        }
    }

}
