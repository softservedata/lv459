/*
 * Given natural numbers n, a1, ..., an.
 * Determine the number of ak sequence members
 * a1, ..., an: c) which are square of even numbers.
 */

/**
 * Package for arithmetic tasks.
 */
package com.softserve.edu;

import com.softserve.edu.bl.SquaresOfEvenNumbersAppl;

import java.util.List;

/**
 * SquaresOfEvenNumbersMain.java.
 *
 * @version 1.0 17 November 2019
 */
public final class SquaresOfEvenNumbersMain {

    private SquaresOfEvenNumbersMain() {
    }

    /**
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        ConsoleOperation co = new ConsoleOperation();
        SquaresOfEvenNumbersAppl soen = new SquaresOfEvenNumbersAppl();

        List<Integer> listOfNumbers = co.getScanner();
        co.print(soen.getSquaresOfEvenNumbers(listOfNumbers));
        co.closeScanner();
    }
}
