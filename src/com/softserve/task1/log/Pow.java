package com.softserve.task1.log;

import java.lang.IllegalArgumentException;

/**
 * <h1>Pow</h1>
 * <p></>The class contain all method that finds the largest integer k,
 * for which 4 ^ k < m.</p>
 */

public final class Pow {


    /**
     * @param num receive value from console.
     * @return true if num>0 or false in another case.
     */
    public boolean isNatural(int num){
        return num > 0;

    }


    /**
     * <h3>This method finds tha largest k for condition 4 ^ k < m.</h3>
     * @param number value is excepted by input method.
     * @return result that return 'k' which is the greatest
     * in all in this condition.
     */

    public int findPow(final int number) throws IllegalArgumentException {
        int res = 0;
        final int n = 4;
        if (isNatural(number)) {
            if (number >= 1 && number <= 4) {
                throw new IllegalArgumentException("No k is possible!");
            }
            for (int k = number; k > 0; k--) {

                double condition = Math.pow(n, k);
                if (condition < number) {
                    res = k;
                    break;
                }
            }
        } else { throw new IllegalArgumentException("Number is not natural!");}
        return res;

    }
}
