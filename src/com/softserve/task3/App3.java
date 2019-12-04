package com.softserve.task3;

import java.util.List;

/**
 * <h1>App3</h1>
 * <p>The  class implements program that finds all Mersenne numbers
 * that are smaller than natural number entered by user. </p>
 * Date      15.09.2019
 *
 */
public class App3 {
    /**
     * This is the main method which implements program.
     * @param args is unused.
     */
    public static void main(final String[] args) {
        ConsoleOperation co = new ConsoleOperation();
        int number = co.getNaturalNumberFromUser();

        MersenneNumbers bl = new MersenneNumbers();
        List<Integer> list = bl.findSmallerThanNumberMersenneNumbers(number);

        co.printMersenneNumbers(number, list);
    }
 }