/*
 * Package for arithmetic tasks.
 */
package com.softserve.edu.bl;

import java.util.ArrayList;
import java.util.List;

/**
 * SquaresOfEvenNumbersAppl.java.
 *
 * @version 1.0 17 November 2019
 */
public class SquaresOfEvenNumbersAppl {

    /**
     * If there is no number that have square root of a number that is even.
     */
    private static final String NOT_FOUND = "There is no natural numbers"
            + " that have square root of a number that is even.";

    /**
     * Constructor.
     */
    public SquaresOfEvenNumbersAppl() {
    }

    /**
     * Check if square root of a number is even.
     *
     * @param number Number to check.
     * @return this number if true.
     */
    public boolean checkSqrt(final int number) {
        return ((Math.sqrt(number) % 2)) == 0 ? true : false;
    }

    /**
     * Check if square root of a number from the list is even.
     *
     * @param list input list.
     * @return a list.
     */
    public List<Integer> getSquaresOfEvenNumbers(final List<Integer> list) {
        List<Integer> sqrtList = new ArrayList<>();
        for (Integer number : list) {
            if (checkSqrt(number)) {
                sqrtList.add(number);
            }
        }
        if (sqrtList.isEmpty()) {
            throw new RuntimeException(NOT_FOUND);
        }
        return sqrtList;
    }

}
