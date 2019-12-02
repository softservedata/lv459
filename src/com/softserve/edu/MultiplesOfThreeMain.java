/*
 * Given natural numbers n, a1, ..., an.
 * Determine the number of ak sequence members
 * a1, ..., an: b) multiples of 3 and not multiples of 5.
 */

/**
 * Package for arithmetic tasks.
 */
package com.softserve.edu;

import com.softserve.edu.bl.MultiplesOfThreeAppl;

import java.util.List;

/**
 * MultiplesOfThreeMain.java.
 *
 * @version 1.0 17 November 2019
 */
public final class MultiplesOfThreeMain {

    private MultiplesOfThreeMain() {
    }

    /**
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        ConsoleOperation co = new ConsoleOperation();
        MultiplesOfThreeAppl mota = new MultiplesOfThreeAppl();

        List<Integer> listOfNumbers = co.getScanner();
        co.print(mota.calculateMultiples(listOfNumbers));
        co.closeScanner();
    }
}
