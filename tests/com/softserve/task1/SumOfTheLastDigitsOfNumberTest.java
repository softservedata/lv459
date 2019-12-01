package com.softserve.task1;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static junit.framework.TestCase.assertEquals;

public class SumOfTheLastDigitsOfNumberTest {
    /**
     * <h3>This method tests calculateSum method.</h3>
     * Test Design Techniques: dynamic techniques:
     * Parameter list:
     * Decision Tables: {<0, 0} {0, <0} {<0, >0} {0, <0} {0,0} {0, >0} {>0, <0} {>0 0} {>0, >0}
     */
    @Test
    public void testcalculateSum1() {
        int expected = 97;
        List<Integer> list = Arrays.asList(50, 2);
        SumOfTheLastDigitsOfNumber sum = new SumOfTheLastDigitsOfNumber();
        int actual = sum.calculateSum(list);
        assertEquals(expected, actual);
    }
}