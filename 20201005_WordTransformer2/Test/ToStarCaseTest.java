import de.telran.data.ToStarCase;
import org.junit.*;
import static org.junit.Assert.*;

public class ToStarCaseTest {
    ToStarCase toStarCase;

    {
        toStarCase = new ToStarCase();
    }

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
        assertEquals(6, "method".length());
    }

    @Test
    public void checkLengthFalse(){
        assertNotEquals(6, "this".length());
    }

    @Test
    public void actionToLowerCase(){
        assertEquals("****", toStarCase.action("well"));
    }
}
