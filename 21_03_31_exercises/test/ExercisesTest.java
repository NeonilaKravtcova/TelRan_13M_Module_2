
import static org.junit.Assert.*;
import org.junit.Test;

public class ExercisesTest {

    String text = "Hello world";

    Exercises exercises = new Exercises();

    @Test
    public void task1Test_text_index0(){
        assertEquals("", exercises.task1(text, 0));
    }

    @Test
    public void task1Test_text_index1(){
        assertEquals("", exercises.task1(text, 1));
    }

    @Test
    public void task1Test_text_index2(){
        assertEquals("", exercises.task1(text, 2));
    }

    @Test
    public void task1Test_text_index3(){
        assertEquals("", exercises.task1(text, 3));
    }

    @Test
    public void task1Test_text_index4(){
        assertEquals("", exercises.task1(text, 4));
    }

    @Test
    public void task1Test_text_index5(){
        assertEquals("Hello", exercises.task1(text, 5));
    }

    @Test
    public void task1Test_text_index6(){
        assertEquals("Hello", exercises.task1(text, 6));
    }

    @Test
    public void task1Test_text_index7(){
        assertEquals("Hello", exercises.task1(text, 7));
    }

    @Test
    public void task1Test_text_index8(){
        assertEquals("Hello", exercises.task1(text, 8));
    }

    @Test
    public void task1Test_text_index9(){
        assertEquals("Hello", exercises.task1(text, 9));
    }

    @Test
    public void task1Test_text_index10(){
        assertEquals("Hello", exercises.task1(text, 10));
    }

    @Test
    public void task1Test_text_index11(){
        assertEquals("Hello world", exercises.task1(text, 11));
    }

    @Test
    public void task1Test_text_index12(){
        assertEquals("Hello world", exercises.task1(text, 12));
    }

    @Test
    public void task1Test_text_index20(){
        assertEquals("Hello world", exercises.task1(text, 20));
    }
}
