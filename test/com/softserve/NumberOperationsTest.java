package com.softserve;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test case for NumberOperations class methods.
 * @version 1.0, 14.11.2019
 */
public class NumberOperationsTest {
    /**
     * Object of number class which methods we should to test.
     */
    private NumberOperations numberOperations = new NumberOperations();

    /**
     * Testing digits count from number. Here i decide to use equivalence
     * partitioning with boundary value testing. I had identified the following
     * sets of inputs {-2147483648 - 0}, {1 - 9}, {10 - 2147483647}
     */
    @Test
    public void testGetDigitsCount() {
        assertEquals(1, numberOperations.getDigitsCount(-1));
        assertEquals(1, numberOperations.getDigitsCount(0));
        assertEquals(1, numberOperations.getDigitsCount(3));
        assertEquals(10, numberOperations.getDigitsCount(Integer.MAX_VALUE));
    }

    /**
     * Testing method for IllegalArgument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetDigitsCountExpection() {
        assertEquals(10, numberOperations.getDigitsCount(-2147483648));
    }

    /**
     * Testing sum of each integer digit. Here i decide to use equivalence
     * partitioning with boundary value testing. I had identified the following
     * sets of inputs {-2147483647 - -1}, {0}, {1 - 2147483647}
     */
    @Test
    public void testGetSumOfDigits() {
        assertEquals(1, numberOperations.getSumOfDigits(-1));
        assertEquals(0, numberOperations.getSumOfDigits(0));
        assertEquals(1, numberOperations.getSumOfDigits(1));
        assertEquals(46, numberOperations.getSumOfDigits(2147483647));
    }

    /**
     * Testing method for IllegalArgument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSumOfDigitsForException() {
        assertEquals(46, numberOperations.getSumOfDigits(-2147483648));
    }

    /**
     * Testing calculating all perfect numbers less than specified value. Here i
     * decide to use equivalence partitioning testing. I had identified the
     * following sets of inputs {0 - 6}, {7- 28}, {28 - 496}, {497 - 8128},
     * {8129 - 33550337}
     */
    @Test
    public void testGetAllPerfectNumbers() {
        List<Integer> arr = new ArrayList<Integer>();
        assertEquals(arr, numberOperations.getAllPerfectNumbers(0));
        arr.add(6);
        assertEquals(arr, numberOperations.getAllPerfectNumbers(-8));
        arr.add(28);
        assertEquals(arr, numberOperations.getAllPerfectNumbers(30));
        arr.add(496);
        assertEquals(arr, numberOperations.getAllPerfectNumbers(500));
        arr.add(8128);
        assertEquals(arr, numberOperations.getAllPerfectNumbers(-9000));
//        arr.add(33550336);
//        assertEquals(numberOperations.getAllPerfectNumbers(33550339), arr);
    }

}
