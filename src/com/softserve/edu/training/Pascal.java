package com.softserve.edu.training;

import java.util.ArrayList;
import java.util.List;


/**
 * Class Pascal was designed to get the Pascal's triangle.
 */
public class Pascal {
    /**
     * This method prints Pascal's triangle to the console.
     *
     * @param number is the user's input.
     * @return Pascal's triangle.
     */
    public List<List<Integer>> generatePascal(final int number) {
        List<List<Integer>> result = new ArrayList<>();
            if (number <= 0) {
                throw new RuntimeException("Wrong input number");
            } else {
                List<Integer> first = new ArrayList<>();
                first.add(1);
                result.add(first);
                for (int i = 1; i < number; i++) {
                    List<Integer> before = result.get(i - 1);
                    List<Integer> now = new ArrayList<>();
                    now.add(1);
                    for (int j = 1; j < i; j++) {
                        now.add(before.get(j - 1) + before.get(j));
                    }
                    now.add(1);
                    result.add(now);
                }
            }
        return result;
    }
}
