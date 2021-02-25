package de.telran;

import org.junit.Assert;
import org.junit.Test;

public class CensorTest {

    Censor censor;

    String text = "i love this badWord1 Java however some of these badWord2 exercises are really badWord3";
    String text1 = "i love this Java however some of these difficult exercises are really interesting";

    @Test
    public void verify_test(){
        Assert.assertTrue(censor.verify(text));
    }

    @Test
    public void verify_test2(){
        Assert.assertFalse(censor.verify(text1));
    }

    @Test
    public void verify_test3(){
        Assert.assertFalse(censor.verify("no bad words at all"));
    }

    @Test
    public void verify_test4(){
        Assert.assertTrue(censor.verify("badWord1"));
    }

    @Test
    public void verify_test5(){
        Assert.assertFalse(censor.verify("badWord5"));
    }
}
