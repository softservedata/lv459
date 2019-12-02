/*
 * Package for arithmetic tasks.
 */
package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ConsoleOperation.java.
 *
 * @version 1.0 17 November 2019
 */
public class ConsoleOperation {

    /**
     * Using scanner.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Get what user has typed.
     *
     * @return the number
     */
    public int getScannerNumber() {
        int i = sc.nextInt();
        return i;
    }

    /**
     * Get what user has typed.
     *
     * @return the list
     */
    public List<Integer> getScanner() {
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        return list;
    }

    /**
     * Print.
     *
     * @param list List to print.
     */
    public void print(final List<Integer> list) {
        System.out.println(list);
    }

    /**
     * Close Scanner.
     */
    public void closeScanner() {
        sc.close();
    }
}
