import de.telran.data.ToUpperCase;
import org.junit.*;

public class ToUpperCaseTest {

    @Before
    public void init(){
        System.out.println("Test start");
    }

    @After
    public void end(){
        System.out.println("Test over");
    }


    @Test
    public void testCheckLength(){
        String input = "Let";
        Assert.assertEquals(3, input.length());
    }

    @Test
    public void testCheckLengthString(){
        String input = "Let us try to solve this";
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + strings[i]);
            Assert.assertEquals("test failed",3, strings[i].length());
        }
    }

    @Test
    public void testAction(){
        ToUpperCase toUpperCase = new ToUpperCase();
        String input = "let";
        Assert.assertEquals("LET", toUpperCase.action(input));
    }

    @Test
    public void testAction2(){
        ToUpperCase toUpperCase = new ToUpperCase();
        String input = "let";
        Assert.assertEquals("Let", toUpperCase.action(input));
    }
}

