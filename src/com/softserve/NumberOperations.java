package com.softserve;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code NumberOperations} class can calculate digits count of your number,
 * sum of each digit of your number, find perfect numbers less than specified
 * number and calculate Armstrong numbers.
 *
 * @see java.util.ArrayList;
 * @see java.util.List;
 * @version 1.1, 21.11.2019
 */

// 86 à) á) 330, 562. - tasks.
public class NumberOperations {
    /**
     * With this number we can separate integer number into digits.
     */
    private static final int DIGIT_SEPARATOR = 10;

    /**
     * Returns the {@code Integer} digits count of number.
     * @param value the number which count of digits count you want to get.
     * @return the {@code int} digits count of {@code value}.
     */
    public int getDigitsCount(final Integer value) {
        // return String.valueOf(value).toCharArray().length;
        return value == 0 ? 1 : getAllDigits(getABS(value)).size();
    };

    /**
     * Calculate sum of digits from specified value.
     * @return the {@code int} sum of digits from List.
     * @param value the number which sum of digits you want to get
     */
    public int getSumOfDigits(final Integer value) {
        int res = 0;
        List<Integer> arg1 = getAllDigits(value);
        for (long i : arg1) {
            res += i;
        }
        return res;
    }

    /**
     * Calculate perfect numbers less then specified number.
     * @param value calculate perfect numbers less than that number.
     * @return the {@code arr} Array List of all perfect numbers less than
     *         specified number.
     */
    public List<Integer> getAllPerfectNumbers(final Integer value) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < getABS(value); i++) {
            if (getSumOfIntegersDivisors(i) == i) {
                arr.add(i);
            }
        }
        return arr;
    }

    /**
     * Calculate sum of integers if the remainder of the division equals zero.
     * @param value calculate integer divisors for a given number.
     * @return the {@code int} sum of digits.
     */
    private int getSumOfIntegersDivisors(final Integer value) {
        int res = 0;
        for (int j = 1; j < value; j++) {
            if (checkReminderOfDivision(value, j)) {
                res += j;
            }
        }
        return res;
    }

    /**
     * Check if remainder of the division equals zero.
     * @param value   {@code long} number that we divide.
     * @param divisor divisor of specified value.
     * @return {@code true} if remainder equals zero.
     */
    private boolean checkReminderOfDivision(final Integer value,
            final int divisor) {
        return (value % divisor) == 0;
    }

    /**
     * Divide number into digits.
     * @return the {@code ArrayList<Integer>} of each digit from number.
     * @param value the number which digits you want to get
     */
    private List<Integer> getAllDigits(final Integer value) {
        List<Integer> res = new ArrayList<>();
        Integer arg0 = getABS(value);
        while (arg0 > 0) {
            res.add(0, arg0 % DIGIT_SEPARATOR);
            arg0 /= DIGIT_SEPARATOR;
        }
        return res;
    }

    /**
     * Get the absolute value of an Integer value.
     * @param value Integer value from which you want to get an absolute value
     * @return Absolute value of an Integer.
     */
    private Integer getABS(final Integer value) {
        return Math.abs(value);
    }
}
