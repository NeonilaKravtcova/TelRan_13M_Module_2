package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList<String> list = new OurArrayList<>();

    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testGet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
    }

    @Test
    public void testRemoveById_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(-10));
    }

    @Test
    public void testSet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "0"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, "0"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-10, "0"));
    }

    @Test
    public void testSizeAndAddLast_addSeveralElements_correctSize() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        assertEquals(3, list.size());
    }

    @Test
    public void testGetAndAddLast_addSeveralElements_correctOrderOfElements() {
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String s : strings) {
            list.addLast(s);
        }

        for (int i = 0; i < strings.length; i++) {
            assertEquals(strings[i], list.get(i));
        }
    }

    @Test
    public void testRemoveById_addSeveralElementsAndRemoveLast_correct() {
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String s : strings) {
            list.addLast(s);
        }

        assertEquals("H", list.removeById(7));
        assertEquals(7, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(7));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(7, "H"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(7));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveLast_correct() {
        //String[] strings = {"0", "1", "2", "3", "4", "5", "6", "6", "I"};
        for (int i = 0; i < 16; i++) {
            list.addLast(Integer.toString(i));
        }

        assertEquals("15", list.removeById(15));
        assertEquals(15, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));

    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast(Integer.toString(i));
        }

        assertEquals("0", list.removeById(0));
        assertEquals(15, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.toString(1 + i), list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveIntermediate_correct() {

        for (int i = 0; i < 18; i++) {
            list.addLast(Integer.toString(i));
        }

        assertEquals("5", list.removeById(5));
//        {0,1,2,3,4,  6,7,8,9,10,11,12,13,14,15,16,17}

        assertEquals(17, list.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(Integer.toString(i), list.get(i));
        }

        for (int i = 5; i < list.size(); i++) {
            assertEquals(Integer.toString(i + 1), list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(17));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(17, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(17));
    }

    @Test
    public void testAddLast_addInitialCapacityPlusOneElements_correctSizAndCapacity() {
        for (int i = 0; i < 17; i++) {
            list.addLast(Integer.toString(i));
        }

        assertEquals(17, list.size());
        assertEquals(32, list.source.length);
    }

    @Test
    public void testSet_toFirstIndex() {

        addElementsToList(5);
        list.set(0, "100098");

        assertEquals("100098", list.get(0));
    }

    @Test
    public void testSet_toLastIndex() {

        addElementsToList(5);
        list.set(list.size() - 1, "404");

        assertEquals("404", list.get(list.size() - 1));
    }

    @Test
    public void set_To_Index_Between_First_And_Last() {

        int numberOfElements = 20;
        addElementsToList(numberOfElements);

        list.set(17, "30998");

        assertEquals("30998", list.get(17));
    }

    @Test
    public void testClear_emptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear_nonEmptyList() {
        addElementsToList(20);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testUniversal_addSeveralElementsThenSetThenRemove_etc() {
        addElementsToList(4);//{0,1,2,3}

        list.removeById(2);//{0,1,3}
        list.set(1, "5");//{0,5,3}

        list.addLast("-10");//{0,5,3,-10}
        list.addLast("-15");//{0,5,3,-10,-15}

        list.removeById(2);//{0,5,-10,-15}
        list.removeById(0);//{5,-10,-15}

        assertEquals(3, list.size());

        assertEquals("5", list.get(0));
        assertEquals("-10", list.get(1));
        assertEquals("-15", list.get(2));
    }

    //------------ HOMEWORK 06.12.2020 --------------- //

    @Test
    public void testRemove_removeElementFromEmptyList() {
        assertFalse(list.remove("any string"));
    }

    @Test
    public void testRemove_addSomeElements_removeElementOnlyOnceIfFound(){
        String[] strings = {"0", "Ivan", "2", "3", "4", "5", "Ivan", "7"};
        for (String s : strings) {
            list.addLast(s);
        }

        assertFalse(list.remove(""));

        assertTrue(list.remove("Ivan"));
        assertEquals("2", list.get(1));
        assertEquals(7, list.size());

        assertTrue(list.contains("Ivan"));
        assertEquals("Ivan", list.get(5));

        assertTrue(list.remove("Ivan"));
        assertFalse(list.contains("Ivan"));
        assertEquals(6, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.get(6)));

    }

    @Test
    public void testContains_addElements_checkIfElementIsFound(){
        String[] strings = {"0", "Ivan", "2", "3", "4", "5", "Ivan", "7"};
        for (String s : strings) {
            list.addLast(s);
        }

        assertTrue(list.contains("Ivan"));
        assertFalse(list.contains("Evan"));

    }



    /**
     * The function fills the list with the numbers from 0 to (number - 1)
     *
     * @param number the amount of numbers to be inserted into the list
     */
    private void addElementsToList(int number) {
        for (int j = 0; j < number; j++) {
            list.addLast(Integer.toString(j));
        }
    }


}
