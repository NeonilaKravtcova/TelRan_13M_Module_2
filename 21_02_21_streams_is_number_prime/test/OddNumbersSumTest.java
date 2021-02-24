import de.telran.OddNumbersSum;
import org.junit.Assert;
import org.junit.Test;

public class OddNumbersSumTest {

    OddNumbersSum sum = new OddNumbersSum();

    @Test
    public void getSum_test(){
        Assert.assertEquals(1, sum.getSum(1, 1));
        Assert.assertEquals(1, sum.getSum(1, 2));
        Assert.assertEquals(4, sum.getSum(1, 3));
        Assert.assertEquals(4, sum.getSum(1, 4));
        Assert.assertEquals(8, sum.getSum(2, 5));
        Assert.assertEquals(39, sum.getSum(10, 15));
    }
}
