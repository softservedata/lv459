/*
 * Package for arithmetic tasks.
 */
package com.softserve.edu.bl;

import java.util.ArrayList;
import java.util.List;

/**
 * PythagoreanTriplesAppl.java.
 *
 * @version 1.0 17 November 2019
 */
public class PythagoreanTriplesAppl {

    /**
     * If Pythagorean triples are not found.
     */
    private static final String NOT_FOUND = "There is no Pythagorean triples"
            + " for this number";

    /**
     * Constructor.
     */
    public PythagoreanTriplesAppl() {
    }

    /**
     * Check sum and square of third number.
     *
     * @param sum Sum.
     * @param c   Third number.
     * @return true or false.
     */
    public boolean checkSumAndC(final int sum, final int c) {
        return sum == (c * c);
    }

    /**
     * Check sum and number that user has typed.
     *
     * @param sum        Sum.
     * @param userNumber number that user has typed.
     * @return true or false.
     */
    public boolean checkSumAndUserNumber(final int sum, final int userNumber) {
        return sum <= userNumber;
    }

    /**
     * Check sum and third number, check sum and number that user has typed.
     *
     * @param c          Third number.
     * @param sum        Sum.
     * @param userNumber number that user has typed.
     * @return true or false.
     */
    public boolean checkSum(final int c, final int sum, final int userNumber) {
        return ((checkSumAndC(sum, c))
                && (checkSumAndUserNumber(sum, userNumber))) ? true : false;
    }

    /**
     * Get sum of ((a * a) + (b * b)).
     *
     * @param a First number.
     * @param b Second number.
     * @return a sum.
     */
    public int getSum(final int a, final int b) {
        int sum = (a * a) + (b * b);
        return sum;
    }

    /**
     * Get square of a number.
     *
     * @param number Number.
     * @return a sum.
     */
    public int multipliedNumber(final int number) {
        int sum = number * number;
        return sum;
    }

    /**
     * Check if triples of natural numbers a, b, c correspond to equation
     * a^2 + b^2 = c^2 and (a <= b <= c <= n).
     *
     * @param userNumber A number that user has typed.
     * @return the pythagoreanTriplesList.
     */
    public List<Integer> getPythagoreanTriples(final int userNumber) {
        List<Integer> pythagoreanTriplesList = new ArrayList<>();
        for (int a = 1; a <= userNumber; a++) {
            for (int b = a; b <= userNumber; b++) {
                for (int c = b; c <= userNumber; c++) {
                    int sum = getSum(a, b);

                    if (checkSum(c, sum, userNumber)) {
                        pythagoreanTriplesList.add(multipliedNumber(a));
                        pythagoreanTriplesList.add(multipliedNumber(b));
                        pythagoreanTriplesList.add(multipliedNumber(c));
                    }
                }
            }
        }
        if (pythagoreanTriplesList.isEmpty()) {
            throw new RuntimeException(NOT_FOUND);
        }
        return pythagoreanTriplesList;
    }
}
