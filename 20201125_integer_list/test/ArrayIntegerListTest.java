import de.telran.ArrayIntegerList;
import de.telran.IntegerList;
import org.junit.*;

import static org.junit.Assert.*;

public class ArrayIntegerListTest {

    IntegerList list = new ArrayIntegerList();

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
        //IntegerList list = (IntegerList)(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        for (int i = 0; i < ArrayIntegerList.source.length; i++) {
            list.addLast(i);
        }
        assertEquals(16, ArrayIntegerList.source.length);
        list.addLast(16);
        assertEquals(32, ArrayIntegerList.source.length);
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
        Assert.fail("Expected IndexOutOfBoundsException");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_index_5_exp_eOOBE(){
        for (int i = 0; i < 4; i++) {
            list.addLast(i);
        }
        list.get(5);
        Assert.fail("Expected IndexOutOfBoundsException");
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
        Assert.fail("Expected IndexOutOfBoundsException");
    }

    @Test(expected = RuntimeException.class)
    public void get_index_3_0_exp_eOOBE() {
        list.get(3);
        Assert.fail("Expected IndexOutOfBoundsException");
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
        Assert.fail("Expected NullPointerException");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void clear_filled_array_to_clear_exp_(){
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        list.clear();
        list.get(0);
        Assert.fail("Expected IndexOutOfBoundsException");
    }

}
