import de.telran.data.ToUpperCase;
import org.junit.*;

import static org.junit.Assert.*;

public class ToUpperCaseTest {

    ToUpperCase toUpperCase = new ToUpperCase();

    @Before
    public void init(){
        System.out.println("Test start");
    }

    @After
    public void end(){
        System.out.println("Test over\n");
    }


    @Test
    public void checkLengthTrue(){
        assertEquals(3, "let".length());
    }

    @Test
    public void checkLengthFalse(){
        assertNotEquals(3, "us".length());
    }

    @Test
    public void actionToUpperCase(){
        assertEquals("LET", toUpperCase.action("let"));
    }
}

