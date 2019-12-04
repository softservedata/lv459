package com.softserve.task1;

import java.util.List;
import java.util.ArrayList;
/**
 * <h1>App1</h1>
 * <p>The class implements program than finds
 * the sum of all last digits of the number.</p>
 * Date      15.09.2019.
 *
 */
public class App1 {
    /**
     * This is the main method which implements program.
     * @param args is unused.
     */
    public static void main(final String[] args) {
        GetNumbers co = new GetNumbers();
        SumOfTheLastDigitsOfNumber sum = new SumOfTheLastDigitsOfNumber();

        List<Integer> myArrayList;
        myArrayList = co.getNumbersFromUser();

        PrintSum printsum = new PrintSum();
        printsum.printSum(sum.calculateSum(myArrayList));
    }
}
