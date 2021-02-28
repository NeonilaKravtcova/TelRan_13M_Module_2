package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TextHandlerTest {

    @Test
    public void palindromFilter_test1(){
        List<String> list = new ArrayList(Arrays.asList("heh", "hello", "hi", "level", "madam", "sir",
                "noon", "twenty"));
        TextHandler textHandler = new TextHandler(list);
        Map<Boolean, List<String>> res = new HashMap<>();
        res.put(false, new ArrayList(Arrays.asList("hello", "hi", "sir", "twenty")));
        res.put(true, new ArrayList(Arrays.asList("heh", "level", "madam", "noon")));

        Assert.assertEquals(res, textHandler.palindromFilter());
    }
}
