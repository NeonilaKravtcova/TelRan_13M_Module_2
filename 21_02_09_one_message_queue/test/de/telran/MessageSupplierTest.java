package de.telran;

import org.junit.Assert;
import org.junit.Test;

public class MessageSupplierTest {

    @Test
    public void readFromConsole_test(){
        Assert.assertEquals("dfg", readFromConsole());
    }

    public String readFromConsole(){
        return String.valueOf(System.in);
    }
}
