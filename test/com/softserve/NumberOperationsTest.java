package com.softserve;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test cafe for NumberOperations class methods.
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
     * sets of inputs {-2147483647 - 0}, {All natural numbers}, {10 -
     * 2147483647}
     */
    @Test
    public void testGetDigitsCount() {
        assertEquals(numberOperations.getDigitsCount(-2147483647), 10);
        assertEquals(numberOperations.getDigitsCount(-1), 1);
        assertEquals(numberOperations.getDigitsCount(0), 1);
        assertEquals(numberOperations.getDigitsCount(1), 1);
        assertEquals(numberOperations.getDigitsCount(2147483647), 10);
    }

    /**
     * Testing sum of each integer digit. Here i decide to use equivalence
     * partitioning with boundary value testing. I had identified the following
     * sets of inputs {-2147483647 - -1}, {0}, {1 - 2147483647}
     */
    @Test
    public void testGetSumOfDigits() {
        assertEquals(numberOperations.getSumOfDigits(-2147483647), 46);
        assertEquals(numberOperations.getSumOfDigits(-1), 1);
        assertEquals(numberOperations.getSumOfDigits(0), 0);
        assertEquals(numberOperations.getSumOfDigits(1), 1);
        assertEquals(numberOperations.getSumOfDigits(2147483647), 46);
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
        assertEquals(numberOperations.getAllPerfectNumbers(0), arr);
        arr.add(6);
        assertEquals(numberOperations.getAllPerfectNumbers(8), arr);
        arr.add(28);
        assertEquals(numberOperations.getAllPerfectNumbers(30), arr);
        arr.add(496);
        assertEquals(numberOperations.getAllPerfectNumbers(500), arr);
        arr.add(8128);
        assertEquals(numberOperations.getAllPerfectNumbers(9000), arr);
//        arr.add(33550336);
//        assertEquals(numberOperations.getAllPerfectNumbers(33550339), arr);
    }

}
