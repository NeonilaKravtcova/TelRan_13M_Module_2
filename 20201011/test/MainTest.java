import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

    @Before
    public void init(){
        System.out.println("Test start");
    }

    @After
    public void end(){
        System.out.println("Test over\n");
    }

    @Test
    public void shiftLeft(){
        assertArrayEquals(Main.shiftLeft(new int[]{6, 2, 5, 3}), (new int[]{2, 5, 3, 6}));
    }

    @Test
    public void palindromeWordCheckTrue(){
        assertTrue(Main.palindromeWordCheck("НАГАН"));
    }

    @Test
    public void palindromeWordCheckFalse(){
        assertFalse(Main.palindromeWordCheck("ЦВЕТОК"));
    }

    @Test
    public void palindromeWordCheck2True(){
        assertTrue(Main.palindromeWordCheck2(new StringBuilder("НАГАН")));
    }

    @Test
    public void palindromeWordCheck2False(){
        assertFalse(Main.palindromeWordCheck2(new StringBuilder("ЦВЕТОК")));
    }

    @Test
    public void fillArray01(){
        assertArrayEquals(Main.fillArray01(10), new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1});
    }

    @Test
    public void fillArray(){
        assertArrayEquals(Main.fillArray(5, 2, 5), new int[]{5,7,9,11,13});
    }

    @Test
    public void findSumMinMaxOfArray(){
        assertEquals(Main.findSumMinMaxOfArray(new int[]{1, 3, 5, 6, 8, 12, 25, 3, 48}), 49);
    }

    @Test
    public void commonEndTrue(){
        assertTrue(Main.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));
    }

    @Test
    public void commonEndFalse(){
        assertFalse(Main.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2}));
    }

    @Test
    public void zeroMax(){
        assertArrayEquals(Main.zeroMax(new int[]{0, 5, 0, 3}), new int[]{5, 5, 3, 3});
    }

    @Test
    public void nonStart(){
        assertEquals(Main.nonStart("Hello", "There"), "ellohere");
    }

    @Test
    public void middleTwo(){
        assertEquals(Main.middleTwo("string"), "ri");
    }
}
