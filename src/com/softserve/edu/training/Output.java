package com.softserve.edu.training;

import java.util.List;

/**
 * Class implements output methods.
 */
public class Output {
    /**
     * @param number is user's input.
     */
    public void out(final int number) {
        System.out.println(number);
    }

    /**
     * @param list is user's input List.
     */
    public void out(final List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @param s is the the user's input string.
     */
    public void out(final String s) {
        System.out.println(s);
    }
}
