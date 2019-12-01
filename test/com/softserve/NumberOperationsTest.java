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
     * Testing digits count from number.
     */
    @Test
    public void testGetDigitsCount() {
        final int expect = 5;
        final int actual = numberOperations.getDigitsCount(12403);
        assertEquals(actual, expect);
        assertEquals(numberOperations.getDigitsCount(7), 1);
        assertEquals(numberOperations.getDigitsCount(0), 1);
    }

    /**
     * Testing sum of each integer digit.
     */
    @Test
    public void testGetSumOfDigits() {
        assertEquals(numberOperations.getSumOfDigits(-1230), 6);
    }

    /**
     * Testing calculating all perfect numbers less than specified value.
     */
    @Test
    public void testGetAllPerfectNumbers() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(28);
        arr.add(496);
        arr.add(8128);
        assertEquals(numberOperations.getAllPerfectNumbers(10000), arr);
    }

    /**
     * Testing calculating all Armstrong numbers with 2-4 digits.
     */
    @Test
    public void testGetArmstrongNumbers() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(153);
        arr.add(370);
        arr.add(371);
        arr.add(407);
        arr.add(1634);
        arr.add(8208);
        arr.add(9474);
        assertEquals(numberOperations.getArmstrongNumbers(), arr);
    }

}
