import de.telran.FactorialCounter;
import org.junit.Assert;
import org.junit.Test;

public class FactorialCounterTest {

    FactorialCounter counter = new FactorialCounter();

    @Test
    public void getFactorial_of1(){
        Assert.assertEquals(1, counter.getFactorial(1));
    }

    @Test
    public void getFactorial_of2(){
        Assert.assertEquals(2, counter.getFactorial(2));
    }

    @Test
    public void getFactorial_of3(){
        Assert.assertEquals(6, counter.getFactorial(3));
    }

    @Test
    public void getFactorial_of4(){
        Assert.assertEquals(24, counter.getFactorial(4));
    }

    @Test
    public void getFactorial_of5(){
        Assert.assertEquals(120, counter.getFactorial(5));
    }

    @Test
    public void getFactorial_of6(){
        Assert.assertEquals(720, counter.getFactorial(6));
    }

    @Test
    public void getFactorial_of7(){
        Assert.assertEquals(5040, counter.getFactorial(7));
    }
}
