package com.softserve.task2;

import java.util.List;
import java.util.ArrayList;

/**
 * <h1>CommonMultiples</h1>
 * <p>The  class  contains all method that finds all common
 * multiples of two numbers that are smaller than their multiplication.</p>
 * Date      15.09.2019
 *
 */

public class CommonMultiples {
    /**
     * <h3>This method multiply two numbers .</h3>
     * @param list contains the numbers to be multiplied.
     * @return multiplication of first and second items from list.
     */
    int multiplication(List<Integer> list) {
        return list.get(0) * list.get(1);
    }

    /**
     * <h3>This method checks if the number is common multiple.</h3>
     * @param number is used for checking.
     * @param list is used for checking.
     * @return true if number is common multiple.
     */
    boolean isCommonMultiple(int number, List<Integer> list) {
        return (number % list.get(0) == 0) && (number % list.get(1) == 0);
    }

    /**
     * <h3>This method finds common multiple of two numbers that are smaller
     * than their multiplication.</h3>
     * @param multiplication is result of multiplication of two numbers.
     * @param list contains two user numbers.
     * @return list of common multiple numbers.
     */
    List<Integer> findCommonMultipleSmallerThanMultiplication(int multiplication,  List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < multiplication; i++) {
            if (isCommonMultiple(i, list)) {
                list1.add(i);
            }
        }
        return list1;
    }
}
