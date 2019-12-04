package com.softserve.task1;

import java.util.List;
/**
 * <h1>SumOfTheLastDigitsOfNumber</h1>
 * <p>The  class  contains method that
 * finds the sum of all the last digits of the number.</p>
 * Date      15.09.2019.
 *
 */
public class SumOfTheLastDigitsOfNumber {
    /**
     * <h3>This method .</h3>
     * @param list - the values of list is checked.
     * @return true is values is natural and false if not.
     */
   boolean isNatural(final List<Integer> list) {
       if((list.get(0) > 0) && (list.get(1) > 0)) {
            return true;
       } else {
           return false;
       }
   }
    /**
     * <h3>This method calculates sum.</h3>
     * @param list - calculation of sum of list items is made.
     * @return result of sum.
     */
    int calculateSum(final List<Integer> list) {
        int result = 0;
        if((list != null) && isNatural(list)) {
            for (int i = list.get(0); i > list.get(0) - list.get(1); i--) {
                 result += i - 1;
            }
        } else {
            throw new IllegalArgumentException("Argument is not correct");
        }
        return result;
    }
}
