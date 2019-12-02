package com.softserve.edu.bl;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 * Here I use:
 * <p>
 * Equivalence Partitioning testing technique:
 * {int MIN_VALUE...24} {25...numbers that have Pythagorean triples}
 * {numbers that have no Pythagorean triples}
 * <p>
 * Boundary Value Analysis:
 * 25, numbers that have Pythagorean triples MAX_VALUE.
 */
public class PythagoreanTriplesApplTest {

    /**
     * Nine.
     */
    private static final int NINE = 9;

    /**
     * Sixteen.
     */
    private static final int SIXTEEN = 16;

    /**
     * Twenty four.
     */
    private static final int TWENTY_FOUR = 24;

    /**
     * Twenty five.
     */
    private static final int TWENTY_FIVE = 25;

    /**
     * PythagoreanTriplesAppl.
     */
    private PythagoreanTriplesAppl pta = new PythagoreanTriplesAppl();

    /**
     * Check if there are Pythagorean triples.
     * Here I use Boundary Value Analysis: 25
     */
    @Test
    public void calculateMultiples1() {
        List<Integer> expected = Arrays.asList(NINE, SIXTEEN, TWENTY_FIVE);
        List<Integer> actual = pta.getPythagoreanTriples(TWENTY_FIVE);
        assertEquals(expected, actual);
    }

    /**
     * Check if there are Pythagorean triples.
     * Here I use Equivalence Partitioning: 24
     */
    @Test(expected = RuntimeException.class)
    public void calculateMultiples2() {
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = pta.getPythagoreanTriples(TWENTY_FOUR);
        assertEquals(expected, actual);
    }
}
