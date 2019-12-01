package com.softserve.task3;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class MersenneNumbersTest {
    /**
     * This method tests isNaturalNumber method.
     * Return true is number is natural.
     */
    @Test
    public void testisNatural1() {
        boolean expected = true;
        MersenneNumbers mn = new MersenneNumbers();
        boolean actual = mn.isNatural(5);
        assertEquals(expected, actual);
    }

    /**
     * This method tests isNaturalNumber method.
     * Return true is number is natural.
     */
    @Test
    public void testisNatural2() {
        boolean expected = false;
        MersenneNumbers mn = new MersenneNumbers();
        boolean actual = mn.isNatural(-25);
        assertEquals(expected, actual);
    }

    /**
     * This method tests mersenne method.
     * It defines a mersenne number.
     */
    @Test
    public void testmersenne1() {
        int expected = 3;
        MersenneNumbers mn = new MersenneNumbers();
        int actual = mn.mersenne(2);
        assertEquals(expected, actual);
    }

    /**
     * This method tests  mersenne method.
     * It defines a mersenne number.
     */
    @Test
    public void testmersenne2() {
        int expected = 15;
        MersenneNumbers mn = new MersenneNumbers();
        int actual = mn.mersenne(4);
        assertEquals(expected, actual);
    }

    /**
     * This method tests isSmallerThanNumber method.
     * This method finds all mersenne numbers that are smaller than some number.
     */
    @Test
    public void testisSmallerThanNumber1() {
        boolean expected = false;
        MersenneNumbers mn = new MersenneNumbers();
        boolean actual = mn.isSmallerThanNumber(10, 31);
        assertEquals(expected, actual);
    }

    /**
     * This method tests isSmallerThanNumber method.
     * This method checks if the mersenne number is smaller than some number.
     */
    @Test
    public void testisSmallerThanNumber2() {
        boolean expected = true;
        MersenneNumbers mn = new MersenneNumbers();
        boolean actual = mn.isSmallerThanNumber(50, 31);
        assertEquals(expected, actual);
    }

    /**
     * This method tests findSmallerThanNumberMersenneNumbers method.
     * The method finds all mersenne numbers that are smaller than some number.
     * Test Design Techniques: dynamic techniques:
     * Parameter number:
     * Equivalence Partitioning: {Integer.MIN_VALUE; 0} {1} {2; Iteger.MAX_VALUE}
     * Boundary Values: 0, 1, 2.
     */
    @Test
    public void testfindSmallerThanNumberMersenneNumbers() {
        List<Integer> actual;
        List<Integer> expected = Arrays.asList(1, 3, 7, 15, 31);
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        actual = mersenneNumbers.findSmallerThanNumberMersenneNumbers(50);
        assertEquals(expected, actual);
    }
}