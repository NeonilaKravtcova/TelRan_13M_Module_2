package de.telran;

import org.junit.*;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.*;

public class ArrayIntegerListTest {

    ArrayIntegerList list = new ArrayIntegerList();

    @Before
    public void init(){
        System.out.println("Test start");
    }

    @After
    public void end(){
        System.out.println("Test is over");
    }

    @Test
    public void addLast_addOneElement_5_expSize_1(){
        list.addLast(5);
        assertEquals(1, list.size());
    }

    @Test
    public void addLast_addThreeElements_expSize_3(){
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        assertEquals(3, list.size());
    }

    @Test
    public void addLast_addOneElement_7_expValue_7(){
        list.addLast(7);
        assertEquals(7, list.get(list.size() - 1));
    }


    @Test
    public void addLast_add17thElement_expCapacity_32(){
        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }
        assertEquals(16, list.source.length);
        list.addLast(16);
        assertEquals(32, list.source.length);

        for (int i = 0; i < list.size(); i++) {
            assertEquals(1 + i, list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));
    }
    }

    @Test
    public void get_index_5_expValue_10(){
        for (int i = 0; i < 7; i++) {
            list.addLast(i * 2);
        }
        assertEquals(10, list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_index_0_exp_eOOBE(){
        list.get(0);
        fail("Expected IndexOutOfBoundsException");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_index_5_exp_eOOBE(){
        for (int i = 0; i < 4; i++) {
            list.addLast(i);
        }
        list.get(5);
        fail("Expected IndexOutOfBoundsException");
    }

    @Test
    public void set_index_5_expValue_10(){
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.set(5, 10);
        assertEquals(10, list.get(5));
    }

    @Test(expected = Throwable.class)
    public void get_index_less_0_exp_eOOBE() {
        list.get(-1);
        fail("Expected IndexOutOfBoundsException");
    }

    @Test(expected = RuntimeException.class)
    public void get_index_3_0_exp_eOOBE() {
        list.get(3);
        fail("Expected IndexOutOfBoundsException");
    }

    @Test
    public void removeById_size_10_expSize_9(){
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.removeById(5);
        assertEquals(9, list.size());
    }

    @Test
    public void removeById_index_5_expValue_15(){
        for (int i = 0; i < 10; i++) {
            list.addLast(i * 3);
        }
        assertEquals(15, list.removeById(5));
    }

    @Test
    public void removeById_index_5_expValue_7(){
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.removeById(5);
        assertEquals(6, list.get(5));
    }

    @Test
    public void clear_size_1_expSize_0(){
        list.addLast(8);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void clear_size_5_expSize_0(){
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void clear_empty_array_to_clear_exp_nullPE(){
        list.clear();
        fail("Expected NullPointerException");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void clear_filled_array_to_clear_exp_(){
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        list.clear();
        list.get(0);
        fail("Expected IndexOutOfBoundsException");
    }

}
