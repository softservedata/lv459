package com.softserve.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Quadratic_if.</h1>
 * <p></>The class contain all method that indicate
 * a pair x, y of natural numbers such that n = x^2 + y^2
 * where x >= y;
 */

class QuadraticIf {

    /**
     * <h3>This method check is x >= y.</h3>
     * @param x value is excepted by input method.
     * @param y value is excepted by input method.
     * @return true if x>=y.
     */
    boolean isBigger(final int x, final int y) {
        return  x >= y;
    }

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
    public List<DataDTO> findQuadratic(final int number) {
        List<DataDTO> list = new ArrayList<>();
        if (isNatural(number)) {
            for (int x = number - 1; x > 1; x--) {
                for (int y = 1 ; y <= x; y++) {
                    int c = numberIssquared(x) + numberIssquared(y);
                    if (isEquals(c, number)) {
                        if (isBigger(x,y)) {
                            list.add(new DataDTO(x, y));
                        }
                    }
                }
            }
        }
        return list;
    }


}
