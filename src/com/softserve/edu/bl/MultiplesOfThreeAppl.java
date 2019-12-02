/*
 * Package for arithmetic tasks.
 */
package com.softserve.edu.bl;

import java.util.ArrayList;
import java.util.List;

/**
 * MultiplesOfThreeAppl.java.
 *
 * @version 1.0 17 November 2019
 */
public class MultiplesOfThreeAppl {

    /**
     * Multiples of tree.
     */
    private static final int MULTIPLES_OF_THREE = 3;

    /**
     * Multiples of five.
     */
    private static final int MULTIPLES_OF_FIVE = 5;

    /**
     * If there is no number that are multiple of 3 and not multiple of 5.
     */
    private static final String NOT_FOUND = "There is no natural numbers"
            + " that are multiple of 3 and not multiple of 5.";

    /**
     * Constructor.
     */
    public MultiplesOfThreeAppl() {
    }

    /**
     * Check if a number is multiple of 3.
     *
     * @param number Number to check.
     * @return true or false.
     */
    public boolean checkForMultiplesOfThree(final int number) {

        return ((number % MULTIPLES_OF_THREE) == 0) ? true : false;
    }

    /**
     * Check if a number is not multiple of 5.
     *
     * @param number Number to check.
     * @return true or false.
     */
    public boolean checkForNotMultiplesOfFive(final int number) {
        return ((number % MULTIPLES_OF_FIVE)) != 0 ? true : false;
    }

    /**
     * Check if a number is multiple of 3 and not multiple of 5.
     *
     * @param number Number to check.
     * @return true or false.
     */
    public boolean checkNumber(final int number) {
        return ((checkForMultiplesOfThree(number))
                && (checkForNotMultiplesOfFive(number))) ? true : false;
    }

    /**
     * Check if ak of the list is multiple of 3 and not multiple of 5.
     *
     * @param list input list
     * @return list that is multiple of 3 and not multiple of 5.
     */
    public List<Integer> calculateMultiples(final List<Integer> list) {
        List<Integer> multiplesList = new ArrayList<>();
        for (Integer number : list) {
            if (checkNumber(number)) {
                multiplesList.add(number);
            }
        }
        if (multiplesList.isEmpty()) {
            throw new RuntimeException(NOT_FOUND);
        }
        return multiplesList;
    }

}
