/*
 * Package for arithmetic tasks.
 */
package com.softserve.edu.bl;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;


/**
 * Here I use:
 * <p>
 * Equivalence Partitioning testing technique:
 * {int MIN_VALUE} {0...even number of square root}
 * {square root of a number is not even}
 * <p>
 * Boundary Value Analysis:
 * 0, even number of square root MAX_VALUE.
 */
public class SquaresOfEvenNumbersApplTest {

    /**
     * Sixteen.
     */
    private static final int SIXTEEN = 16;

    /**
     * Seventeen.
     */
    private static final int SEVENTEEN = 17;

    /**
     * SquaresOfEvenNumbersAppl.
     */
    private SquaresOfEvenNumbersAppl soen = new SquaresOfEvenNumbersAppl();

    /**
     * Check if square root of a number is even.
     * Here I use Equivalence Partitioning: 16.
     */
    @Test
    public void calculateMultiples1() {
        List<Integer> expected = Arrays.asList(SIXTEEN);
        List<Integer> list = Arrays.asList(SIXTEEN, SEVENTEEN);
        List<Integer> actual = soen.getSquaresOfEvenNumbers(list);
        assertEquals(expected, actual);
    }

    /**
     * Check if square root of a number is even.
     * Here I use Boundary Value: 0.
     */
    @Test
    public void calculateMultiples2() {
        List<Integer> expected = Arrays.asList(0);
        List<Integer> list = Arrays.asList(0);
        List<Integer> actual = soen.getSquaresOfEvenNumbers(list);
        assertEquals(expected, actual);
    }

    /**
     * Check if square root of a number is even.
     * Here I use Equivalence Partitioning: -1.
     */
    @Test(expected = RuntimeException.class)
    public void calculateMultiples3() {
        List<Integer> expected = Arrays.asList();
        List<Integer> list = Arrays.asList(-1);
        List<Integer> actual = soen.getSquaresOfEvenNumbers(list);
        assertEquals(expected, actual);
    }
}
