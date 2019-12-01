package com.softserve.task2;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static junit.framework.TestCase.assertEquals;

public class CommonMultiplesTest {
    /**
     * <h3>This method tests multiplication method.</h3>
     * It finds multiplication of first and second items from list.
     */
    @Test
    public void multiplication() {
        List<Integer> list = Arrays.asList(12, 18);
        CommonMultiples commonMultiples = new CommonMultiples();
        int expected = 216;
        int actual = commonMultiples.multiplication(list);
        assertEquals(expected, actual);
    }

    /**
     * <h3>This method tests isCommonMultiple method.</h3>
     * Return true if number is common multiple and false if it is not.
     */
    @Test
    public void isCommonMultiple() {
        int number = 36;
        List<Integer> list = Arrays.asList(12, 18);
        CommonMultiples cm = new CommonMultiples();
        boolean actual = cm.isCommonMultiple(number, list);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * <h3>This method tests the findMultipleSmallerThanMultiplication method.</h3>
     * Test Design Techniques: dynamic techniques :
     * Parameter multiplication:
     * Equivalence Partitioning: {Integer.MIN_VALUE; 0} {1} {2; Iteger.MAX_VALUE}
     * Boundary Values: 0, 1, 2.
     * Parameter list:
     * Decision Tables: {<0, 0} {0, <0} {<0, >0} {0, <0} {0, 0} {0, >0} {>0, <0} {>0, 0} {>0, >0}
     */
    @Test
    public void findMultipleSmallerThanMultiplication() {
        List<Integer> list = Arrays.asList(12, 18);
        int multiplication = 12*18;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
        List<Integer> expected = Arrays.asList(36, 72, 108, 144, 180);
        assertEquals(expected, actual);
    }
}