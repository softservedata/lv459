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
     * sets of inputs {-2147483648 - 0}, {1 - 9}, {10 - 2147483647} 0 1 9 10
     */
    @Test
    public void testGetDigitsCountboundary() {
        assertEquals("Error in testGetDigitsCountboundary method", 1,
                numberOperations.getDigitsCount(0));
    }

    /**
     * Testing digits count from number.
     */
    @Test
    public void testGetDigitsCountBoundaryOne() {
        assertEquals("Error in testGetDigitsCountBoundaryOne method", 1,
                numberOperations.getDigitsCount(1));
    }

    /**
     * Testing digits count from number.
     */
    @Test
    public void testGetDigitsCountBoundaryNine() {
        assertEquals("Error in testGetDigitsCountBoundaryNine method", 1,
                numberOperations.getDigitsCount(9));
    }

    /**
     * Testing digits count from number.
     */
    @Test
    public void testGetDigitsCountBoundaryTen() {
        assertEquals("Error in testGetDigitsCountBoundaryTen method", 2,
                numberOperations.getDigitsCount(10));
    }

    /**
     * Testing digits count from number.
     */
    @Test
    public void testGetDigitsCount() {
        assertEquals("Error in testGetDigitsCount method", 10,
                numberOperations.getDigitsCount(Integer.MAX_VALUE));
    }

    /**
     * Testing method for IllegalArgument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetDigitsCountExpection() {
        assertEquals("Error in testGetDigitsCountExpection method", 10,
                numberOperations.getDigitsCount(Integer.MIN_VALUE));
    }

    /**
     * Testing sum of each integer digit. Here i decide to use equivalence
     * partitioning with boundary value testing. I had identified the following
     * sets of inputs {-2147483648 - 0}, {1-9}, {10 - 2147483647}
     */
    @Test
    public void testGetSumOfDigitsBoundary() {
        assertEquals("Error in testGetSumOfDigitsBoundary method", 0,
                numberOperations.getSumOfDigits(0));
    }

    /**
     * Testing sum of digits count from number.
     */
    @Test
    public void testGetSumOfDigitsBoundaryOne() {
        assertEquals("Error in testGetSumOfDigitsBoundaryOne method", 1,
                numberOperations.getSumOfDigits(1));
    }

    /**
     * Testing sum of digits count from number.
     */
    @Test
    public void testGetSumOfDigitsBoundaryNine() {
        assertEquals("Error in testGetSumOfDigitsBoundaryNine method", 9,
                numberOperations.getSumOfDigits(9));
    }

    /**
     * Testing sum of digits count from number.
     */
    @Test
    public void testGetSumOfDigitsBoundaryTen() {
        assertEquals("Error in testGetSumOfDigitsBoundaryTen method", 1,
                numberOperations.getSumOfDigits(10));
    }

    /**
     * Testing sum of digits count from number.
     */
    @Test
    public void testGetSumOfDigitsMax() {
        assertEquals("Error in testGetSumOfDigitsMax method", 46,
                numberOperations.getSumOfDigits(Integer.MAX_VALUE));
    }

    /**
     * Testing sum of digits count from number.
     */
    @Test
    public void testGetSumOfDigits() {
        assertEquals("Error in testGetSumOfDigits method", 9,
                numberOperations.getSumOfDigits(9));
    }

    /**
     * Testing method for IllegalArgument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSumOfDigitsForException() {
        assertEquals("Error in testGetSumOfDigitsForException method", 46,
                numberOperations.getSumOfDigits(Integer.MIN_VALUE));
    }

    /**
     * Testing calculating all perfect numbers less than specified value. Here i
     * decide to use equivalence partitioning testing. I had identified the
     * following sets of inputs {-2147483648 - -1}, {0 - 6} {7 - 28}, {28 -
     * 496}.
     */
    @Test
    public void testGetAllPerfectNumbersOne() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        assertEquals("Error in testGetAllPerfectNumbersOne method", arr,
                numberOperations.getAllPerfectNumbers(8));
    }

    /**
     * Testing method with two output values.
     */
    @Test
    public void testGetAllPerfectNumbersTwo() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(28);
        assertEquals("Error in testGetAllPerfectNumbersTwo method", arr,
                numberOperations.getAllPerfectNumbers(30));
    }

    /**
     * Testing method for IllegalArgument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllPerfectNumbersForException() {
        List<Integer> arr = new ArrayList<Integer>();
        assertEquals("Error in testGetAllPerfectNumbersForException method",
                arr, numberOperations.getAllPerfectNumbers(-1));

    }
}