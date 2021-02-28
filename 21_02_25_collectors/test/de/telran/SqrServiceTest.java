package de.telran;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SqrServiceTest {

    SqrService sqrService = new SqrService();


    @Test
    public void sqrSum_0(){
        assertEquals(0, sqrService.sumSqr(Arrays.asList(0)));
    }

    @Test
    public void sqrSum_1(){
        assertEquals(1, sqrService.sumSqr(Collections.singletonList(1)));
    }

    @Test
    public void sqrSum_range1_5(){
        assertEquals(55, sqrService.sumSqr(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void sqrSum_numbers2_4_6(){
        assertEquals(56, sqrService.sumSqr(Arrays.asList(2, 4, 6)));
    }

    @Test
    public void sqrSum_numbers0_10(){
        assertEquals(100, sqrService.sumSqr(Arrays.asList(0, 10)));
    }

    @Test
    public void multiplySqr_0(){
        assertEquals(0, sqrService.multiplySqr(Arrays.asList(0)));
    }

    @Test
    public void multiplySqr_1(){
        assertEquals(1, sqrService.multiplySqr(Arrays.asList(1)));
    }

    @Test
    public void multiplySqrt_numbers0_10(){
        assertEquals(0, sqrService.multiplySqr(Arrays.asList(0, 10)));
    }

    @Test
    public void multiplySqrt_range1_5(){
        assertEquals(14400, sqrService.multiplySqr(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void multiplySqrt_numbers5_10(){
        assertEquals(2500, sqrService.multiplySqr(Arrays.asList(5, 10)));
    }

}
