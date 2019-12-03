package com.softserve.academy;

public class CheckNumberValidity {

    /** Maximum number with which algorithm can work. */
    private final int MAX_VALUE = 99999999;

    /**
     * Checks if input number in natural, i.e. more that 0.
     *
     * @param outputNumber calculated number
     * @return if output number is in range - than true.
     */
    public boolean inRangeReplacementCheck(int outputNumber) {
        if (outputNumber >= 0) {
            return true;
        }
        return false;
    }

    /**
     * Check if final number will be in Integer range.
     *
     * @param input input number
     * @return result
     */
    public boolean inRangeAdd11Check(int input) {

        if (input > MAX_VALUE) {
            return false;
        }
        return true;
    }

    public boolean isNumberNatural(NumberDTO numberDTO) {
        if (numberDTO.getInputNumber() > 0
            && numberDTO.getInputNumber() % 1 == 0) {
            return true;
        }
        return false;
    }
}
