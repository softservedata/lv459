package com.softserve.academy;

/*
@todo comments
 */
/**
 * This is an algorithm for solving task 88 c): replace last and fist digits of
 * the given number.
 */
public class Task88C {

    /**
     * Empty constructor.
     */
    public Task88C() {
    }

    /**
     * This method contains algorithm. Includes necessary checks to be passed
     * for code to work correctly prior starting algorithm.
     * Algorithm c): - will produce error message if given
     * number is less than zero.
     * Will produce error if final number is out of Integer range.
     * @param numberDTO input
     * @return DTO object with result
     */
    public NumberDTO doTask88c(final NumberDTO numberDTO) {

        Calc calculationsOnNumber = new Calc();
        CheckNumberValidity checkNumberValidity = new CheckNumberValidity();

        calculationsOnNumber.calculations(numberDTO.getInputNumber());
        numberDTO.setResultNumber(replaceLastAndFirstNumber(
                calculationsOnNumber, numberDTO.getInputNumber()));

        if (checkNumberValidity.inRangeReplacementCheck(numberDTO.
                getInputNumber())) {
            numberDTO.setMessage("ReplaceLastAndFirstNumber: SUCCESS");
        } else {
            numberDTO.setMessage("ReplaceLastAndFirstNumber: FAILURE - "
                    + "Result number is not valid (out of Integer range)!!!");
        }

        return numberDTO;
    }

    /**
     * Algorithm for replacing first and last digits of the given number.
     * @param input  - calculation object, given number
     * @param calculations - calculation object, given number
     * @Output - algorithm result
     * @return - replaced number
     */
    public int replaceLastAndFirstNumber(final Calc calculations,
                                         final int input) {
        return input
        + calculations.getLastDigit() * calculations.getMultiplicationStep()
        - calculations.getFirstDigit() * calculations.getMultiplicationStep()
        - calculations.getLastDigit()
        + calculations.getFirstDigit();
    }
}
