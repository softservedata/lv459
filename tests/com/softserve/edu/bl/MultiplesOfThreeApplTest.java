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
 * {int MIN_VALUE...2} {3...multiple of three and not multiple of five}
 * {not multiple of three}
 * <p>
 * Boundary Value Analysis:
 * 3, multiple of three and not multiple of five MAX_VALUE.
 */
public class MultiplesOfThreeApplTest {

    /**
     * Multiples of tree.
     */
    private static final int MULTIPLES_OF_THREE = 3;

    /**
     * Multiples of five.
     */
    private static final int MULTIPLES_OF_FIVE = 5;

    /**
     * Multiples of seven.
     */
    private static final int MULTIPLES_OF_SEVEN = 7;

    /**
     * MultiplesOfThreeAppl.
     */
    private MultiplesOfThreeAppl mota = new MultiplesOfThreeAppl();

    /**
     * Check if a number is multiple of three.
     * Here I use Boundary Value Analysis: 3.
     */
    @Test
    public void calculateMultiples1() {
        List<Integer> expected = Arrays.asList(MULTIPLES_OF_THREE);
        List<Integer> list = Arrays.asList(MULTIPLES_OF_THREE,
                MULTIPLES_OF_FIVE);
        List<Integer> actual = mota.calculateMultiples(list);
        assertEquals(expected, actual);
    }

    /**
     * Check if a number is multiple of three.
     * Here I use Equivalence Partitioning: 0.
     */
    @Test(expected = RuntimeException.class)
    public void calculateMultiples2() {
        List<Integer> expected = Arrays.asList();
        List<Integer> list = Arrays.asList(0);
        List<Integer> actual = mota.calculateMultiples(list);
        assertEquals(expected, actual);
    }

    /**
     * Check if a number is multiple of three.
     * Here I use Equivalence Partitioning: 0.
     */
    @Test(expected = RuntimeException.class)
    public void calculateMultiples3() {
        List<Integer> expected = Arrays.asList();
        List<Integer> list = Arrays.asList(MULTIPLES_OF_SEVEN);
        List<Integer> actual = mota.calculateMultiples(list);
        assertEquals(expected, actual);
    }
}
