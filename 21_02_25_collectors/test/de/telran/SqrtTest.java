package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SqrtTest {

    @Test
    public void sqrtSum_0(){
        Assert.assertEquals(0, new Sqrt(Arrays.asList(0)).sumSqrt());
    }

    @Test
    public void sqrtSum_1(){
        Assert.assertEquals(1, new Sqrt(Arrays.asList(1)).sumSqrt());
    }

    @Test
    public void sqrtSum_range1_5(){
        Assert.assertEquals(55, new Sqrt(Arrays.asList(1, 2, 3, 4, 5)).sumSqrt());
    }

    @Test
    public void sqrtSum_numbers2_4_6(){
        Assert.assertEquals(56, new Sqrt(Arrays.asList(2, 4, 6)).sumSqrt());
    }

    @Test
    public void sqrtSum_numbers0_10(){
        Assert.assertEquals(100, new Sqrt(Arrays.asList(0, 10)).sumSqrt());
    }

    @Test
    public void multiplySqrt_0(){
        Assert.assertEquals(0, new Sqrt(Arrays.asList(0)).multiplySqrt());
    }

    @Test
    public void multiplySqrt_1(){
        Assert.assertEquals(1, new Sqrt(Arrays.asList(1)).multiplySqrt());
    }

    @Test
    public void multiplySqrt_numbers0_10(){
        Assert.assertEquals(0, new Sqrt(Arrays.asList(0, 10)).multiplySqrt());
    }

    @Test
    public void multiplySqrt_range1_5(){
        Assert.assertEquals(14400, new Sqrt(Arrays.asList(1, 2, 3, 4, 5)).multiplySqrt());
    }

    @Test
    public void multiplySqrt_numbers5_10(){
        Assert.assertEquals(2500, new Sqrt(Arrays.asList(5, 10)).multiplySqrt());
    }
}
