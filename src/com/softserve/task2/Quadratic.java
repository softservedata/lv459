package com.softserve.task2;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Quadratic.</h1>
 * <p></>The class contain all method that indicate
 * a pair x, y of natural numbers such that n = x^2 + y^2;
 */

public class Quadratic {

    /**
     * <h3>This method calculate number in square.</h3>
     * @param num value is excepted by input method.
     * @return num is multiplied by itself.
     */
    private int numberIssquared(final int num) {
        final int i = num * num;
        return i;
    }

    /**
     * @param num receive value from console.
     * @return true if num>0 or false in another case.
     */
    boolean isNatural(int num){
        return num > 0;

    }

    /**
     * @param num1 receive sum of x^2+y^2.
     * @param num2 receive value from console.
     * @return true if value from console = x^2+y^2.
     */
    boolean isEquals(int num1, int num2){
        return num1 == num2;

    }

    /**
     * <h3>This method find all x and y in condition
     * n = x^2 + y^2.</h3>
     * @param number value is excepted by input method.
     * @return list of x and y;.
     */
    public List<DataDTO> findQuadratic(final int number) throws IllegalArgumentException {
        List<DataDTO> list = new ArrayList<>();
        if (isNatural(number)) {
            for (int x = 1; x <= number/2; x++) {
                for (int y = x; y <= number/2; y++) {
                    int c = numberIssquared(x) + numberIssquared(y);
                    if (isEquals(c, number)) {
                        list.add(new DataDTO(x, y));
                        if (x != y) {
                            list.add(new DataDTO(y, x));
                        }
                    }
                }
            }
        } else { throw new IllegalArgumentException("Number is not natural!");}
        return list;
    }
}



