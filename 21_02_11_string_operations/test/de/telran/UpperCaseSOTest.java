package de.telran;

import de.telran.operation.UpperCaseSO;
import org.junit.Assert;
import org.junit.Test;

public class UpperCaseSOTest {

    UpperCaseSO upperCaseSO = new UpperCaseSO();

    @Test
    public void UpperCaseSO_test() {
        Assert.assertEquals("HELLO", upperCaseSO.operate("hello"));
        Assert.assertEquals("ONE_TWO_THREE#", upperCaseSO.operate("one_two_three#"));
        Assert.assertEquals("1BONJOUR2", upperCaseSO.operate("1bonjour2"));
        Assert.assertEquals("12345", upperCaseSO.operate("12345"));
        Assert.assertEquals("HI", upperCaseSO.operate("HI"));
    }

}
