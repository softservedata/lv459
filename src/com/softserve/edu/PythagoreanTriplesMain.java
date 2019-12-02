/*
 * 554. A natural number n is given. Get all the Pythagorean triples of
 * natural numbers, each of which does not exceed n, i.e. all such
 * triples of natural numbers a, b, c,
 * that a ^ 2 + b ^ 2 = c ^ 2 (a <= b <= c <= n).
 */

/**
 * Package for arithmetic tasks.
 */
package com.softserve.edu;

import com.softserve.edu.bl.PythagoreanTriplesAppl;

/**
 * PythagoreanTriplesMain.java.
 *
 * @version 1.0 17 November 2019
 */
public final class PythagoreanTriplesMain {

    private PythagoreanTriplesMain() {
    }

    /**
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        ConsoleOperation co = new ConsoleOperation();
        PythagoreanTriplesAppl pta = new PythagoreanTriplesAppl();

        int list = co.getScannerNumber();
        co.print(pta.getPythagoreanTriples(list));
        co.closeScanner();
    }
}
