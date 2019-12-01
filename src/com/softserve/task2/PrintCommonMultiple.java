package com.softserve.task2;

import java.util.List;
/**
 * <h1>PrintCommonMultiples</h1>
 * <p>The class is used to print common multiples of numbers.</p>
 * Date      15.09.2019.
 */

public class PrintCommonMultiple {
    /**
     * <h3>This method prints common multiples.</h3>
     * @param list is printed.
     * @return list.
     */
    public List<Integer> printCommonMultiple(final List<Integer> list) {
        System.out.println("Common multiples smaller than multiplication of numbers are: " + list);
        return list;
    }
}