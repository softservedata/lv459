package com.softserve.task2;

import java.util.List;

/**
 * <h1>App2</h1>
 * <p>The  class  implements program that finds all common
 * multiples of two numbers that are smaller than their multiplication.</p>
 * Date     15.09.2019
 *
 */
public class App2 {
    /**
     * This is the main method which implements program.
     * @param args is unused.
     */
    public static void main(final String[] args) {
        GetNumbers gn = new GetNumbers();
        List<Integer> myArrayList = gn.getNumbersFromUser();

        CommonMultiples cm = new CommonMultiples();
        int multiplication = cm.multiplication(myArrayList);

        List<Integer> result = cm.findCommonMultipleSmallerThanMultiplication(multiplication, myArrayList);
        PrintCommonMultiple print = new PrintCommonMultiple();
        print.printCommonMultiple(result);
    }
}
