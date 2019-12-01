package com.softserve.task3;

import java.util.List;
import java.util.ArrayList;

/**
 * <h1>MersenneNumbers</h1>
 * <p>The class contains all method that finds
 * all Mersenne numbers that are smaller than natural number n.</p>
 * Date      15.09.2019
 *
 */
public class MersenneNumbers {
    /**
     * <h3>This method checks if the number is natural.</h3>
     * @param num is number that is checked.
     * @return true if number is natural, and false if not.
     */
    boolean isNatural(int num) {
        return num > 0;
    }

    /**
     * <h3>This method defines a mersenne number.</h3>
     * @param i is used for definition mersenne numbers.
     * @return mersenne number.
     */
    int mersenne(int i) {
        return ((int) Math.pow(2, i) - 1);
    }

    /**
     * <h3>This method checks if the mersenne number is smaller than some number.</h3>
     * @param number is some number.
     * @param mersenne is mersenne number.
     * @return true if smaller and false if not.
     */
   boolean isSmallerThanNumber(int number, int mersenne) {
       return mersenne < number;
    }

    /**
     * <h3>This method finds all mersenne numbers that are smaller than some number.</h3>
     * @param number is the number entered by user.
     * @return list of all mersenne numbers that are smaller than number.
     */
   public List<Integer> findSmallerThanNumberMersenneNumbers(int number) {
       List<Integer> list = new ArrayList<>();
        if (isNatural(number)) {
            for (int i = 1; i < number; i++) {
                if (isSmallerThanNumber(number, mersenne(i))) {
                    list.add(mersenne(i));
                }
            }
        }
        return list;
    }
}
