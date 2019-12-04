package com.softserve.task3;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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
        assertEquals("Error in isNatural method", expected, actual);
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
        assertEquals("Error in isNatural method", expected, actual);
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
        assertEquals("Error in mersenne method", expected, actual);
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
        assertEquals("Error in mersenne method", expected, actual);
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
        assertEquals("Error in isSmallerThanNumber method", expected, actual);
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
        assertEquals("Error in isSmallerThanNumber method", expected, actual);
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
    public void testfindSmallerThanNumberMersenneNumbers1() {
        List<Integer> actual;
        List<Integer> expected = Arrays.asList(1, 3, 7, 15, 31);
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        actual = mersenneNumbers.findSmallerThanNumberMersenneNumbers(50);
        assertEquals("Error in findSmallerThanNumberMersenneNumbers", expected, actual);
    }

    /**
     * This method tests findSmallerThanNumberMersenneNumbers method.
     * The method finds all mersenne numbers that are smaller than some number.
     * In this case the boundary value 2 is checked.
     */
    @Test
    public void testfindSmallerThanNumberMersenneNumbers2() {
        List<Integer> actual;
        List<Integer> expected = Arrays.asList(1);
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        actual = mersenneNumbers.findSmallerThanNumberMersenneNumbers(2);
        assertEquals("Error in findSmallerThanNumberMersenneNumbers", expected, actual);
    }

    /**
     * This method tests findSmallerThanNumberMersenneNumbers method.
     * The method finds all mersenne numbers that are smaller than some number.
     * In this case the boundary value 1 is checked.
     */
    @Test
    public void testfindSmallerThanNumberMersenneNumbers3() {
        List<Integer> actual;
        List<Integer> expected = new ArrayList<>();
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        actual = mersenneNumbers.findSmallerThanNumberMersenneNumbers(1);
        assertEquals("Error in findSmallerThanNumberMersenneNumbers", expected, actual);
    }

    /**
     * This method tests findSmallerThanNumberMersenneNumbers method.
     * The method finds all mersenne numbers that are smaller than some number.
     * This is the negative test in which the boundary value 0 is checked.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testfindSmallerThanNumberMersenneNumbers4() {
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        mersenneNumbers.findSmallerThanNumberMersenneNumbers(0);
    }

    /**
     * This method tests findSmallerThanNumberMersenneNumbers method.
     * This is negative test where number is negative.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testfindSmallerThanNumberMersenneNumbers5() {
        MersenneNumbers mersenneNumbers = new MersenneNumbers();
        mersenneNumbers.findSmallerThanNumberMersenneNumbers(-50);
    }
}