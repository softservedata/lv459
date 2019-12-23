package com.softserve.academy;

/**
 * This is an algorithm for solving task 88 c) - replace first and last digit
 * in the given natural number.
 */
public class Task88D {
    /**
     * This method contains algorithms. Includes necessary checks to be passed
     * for code to work correctly prior starting algorithm.
     * Algorithm d): - will produce error message if given number is less
     * than zero. - will produce error if final number is out of Integer range.
     */

    private final int DECIMAL = 10;

    /**
     * Just empty constructor.
     */
    public Task88D() {
    }

    /**
     * Replace first and last digit in the given natural number.
     *
     * @param numberDTO input
     * @return DTO object with result
     */
    public NumberDTO doTask88D(final NumberDTO numberDTO) {

        Calc calcResult = new Calc();
        CheckNumberValidity checkNumberValidity = new CheckNumberValidity();

        calcResult.calculations(numberDTO.getInputNumber());

        numberDTO.setResultNumber(add1EndAndBeginning(calcResult,
                numberDTO.getInputNumber()));

        if (checkNumberValidity.inRangeAdd11Check(numberDTO.getInputNumber())) {
            numberDTO.setMessage(
                    "Adding 1(beginning) and 1(end): SUCCESS");
        } else {
            numberDTO.setMessage(
                    "Adding 1(beginning) and 1(end): FAILURE - Result number "
                            + "is not valid (out of Integer range)!!!");
        }
        return numberDTO;
    }

    /**
     * Algorithm for adding "1" in the beginning and "1" at the end og the
     * given number. Algorithm for replacing last and fist digits of the given
     * number.
     * @return final number
     * @param input input data
     * @param calculations calculations on number
     */
    public int add1EndAndBeginning(final Calc calculations, final int input) {
        return (input + calculations.getMultiplicationStep()
                * DECIMAL) * DECIMAL + 1;
    }
}
