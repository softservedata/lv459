package com.softserve.task2;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
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
        assertEquals("Error in multplication method", expected, actual);
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
        assertEquals("Error in isCommonMultiple method", expected, actual);
    }

    /**
     * <h3>This method tests the findMultipleSmallerThanMultiplication method.</h3>
     * Test Design Techniques: dynamic techniques:
     * Parameter multiplication:
     * Equivalence Partitioning: {Integer.MIN_VALUE; 0} {1} {2; Iteger.MAX_VALUE}
     * Boundary Values: 0, 1, 2.
     * Parameter list:
     * Decision Tables: {<0, 0} {0, <0} {<0, >0} {0, <0} {0, 0} {0, >0} {>0, <0} {>0, 0} {>0, >0}
     * {the first number is equal to the second number} {numbers without common multiples}
     * {numbers have 1 common multiples} {numbers have 2 or more common mulptiples}
     */
    @Test
    public void findMultipleSmallerThanMultiplication1() {
        List<Integer> list = Arrays.asList(12, 18);
        int multiplication = 12 * 18;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
        List<Integer> expected = Arrays.asList(36, 72, 108, 144, 180);
        assertEquals("Error in findMultipleSmallerThanMultiplication method", expected, actual);
    }

    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This test checks how the method works when there are two equal numbers.
     */
    @Test
    public void findMultipleSmallerThanMultiplication2() {
        List<Integer> list = Arrays.asList(10, 10);
        int multiplication = 10 * 10;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        assertEquals("Error in findMultipleSmallerThanMultiplication method", expected, actual);
    }

    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This test checks how the method works when there are numbers without common multiples
     * that are smaller than their multiplication.
     */
    @Test
    public void findMultipleSmallerThanMultiplication3() {
        List<Integer> list = Arrays.asList(13, 22);
        int multiplication = 13 * 22;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
        List<Integer> expected = new ArrayList<>();
        assertEquals("Error in findMultipleSmallerThanMultiplication method", expected, actual);
    }

    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This test checks how the method works when there are numbers with one
     * common multiple smaller than their multiplication.
     */
    @Test
    public void findMultipleSmallerThanMultiplication4() {
        List<Integer> list = Arrays.asList(6, 4);
        int multiplication = 6 * 4;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
        List<Integer> expected = Arrays.asList(12);
        assertEquals("Error in findMultipleSmallerThanMultiplication method", expected, actual);
    }

    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This test checks how the method works when there are numbers without common multiples
     * that are smaller than their multiplication.
     */
    @Test(expected = IllegalArgumentException.class)
    public void findMultipleSmallerThanMultiplication5() {
        List<Integer> list = Arrays.asList(-10, 22);
        int multiplication = -10 * 22;
        CommonMultiples cm = new CommonMultiples();
        List<Integer> actual = cm.findCommonMultipleSmallerThanMultiplication(multiplication, list);
    }
    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This is negative test for IllegalArgumentException when multiplication is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void findMultipleSmallerThanMultiplication6() {
        CommonMultiples cm = new CommonMultiples();
        cm.findCommonMultipleSmallerThanMultiplication(-20, Arrays.asList(10, 2));
    }

    /**
     * This method tests the findMultipleSmallerThanMultiplication method.
     * This is negative test for IllegalArgumentException when list is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void findMultipleSmallerThanMultiplication7() {
        List<Integer> list = null;
        CommonMultiples cm = new CommonMultiples();
        cm.findCommonMultipleSmallerThanMultiplication(200, list);
    }
}