import de.telran.data.ToLowerCase;
import org.junit.*;
import static org.junit.Assert.*;

public class ToLowerCaseTest {
    ToLowerCase toLowerCase;

    {
        toLowerCase = new ToLowerCase();
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
        assertEquals(4, "this".length());
    }

    @Test
    public void checkLengthFalse(){
        assertNotEquals(4, "try".length());
    }

    @Test
    public void actionToLowerCase(){
        assertEquals("this", toLowerCase.action("THIS"));
    }

}
