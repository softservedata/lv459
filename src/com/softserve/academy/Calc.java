package com.softserve.academy;

/**
 * Contains method for number analyzing and preparation
 * for solving algorithm task no 88 c) and d).
 */
public class Calc {
    /**
     * Multiplication step.
     */
    private final int DECIMAL = 10;

    /** Internal cycle param. */
    private int inCycle = 0;

    /** First digit of the number. */
    private int firstDigit = 0;

    /** Last digit of the number. */
    private int lastDigit = 0;

    /** Multiplication step of the given number. */
    private int multiplicationStep = 1;

    public int getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(int lastDigit) {
        this.lastDigit = lastDigit;
    }

    public int getFirstDigit() {
        return firstDigit;
    }

    public void setFirstDigit(int firstDigit) {
        this.firstDigit = firstDigit;
    }

    public int getMultiplicationStep() {
        return multiplicationStep;
    }

    public void setMultiplicationStep(int multiplicationStep) {
        this.multiplicationStep = multiplicationStep;
    }

    /**
     * Analyzes and prepare the input number for next
     * modifications according to task 88 c) and d).
     *
     * @param input number
     */
    public void calculations(final int input) {

        inCycle = input;
        lastDigit = inCycle % DECIMAL;
        if (input > DECIMAL) {
            do {
                inCycle = inCycle / DECIMAL;
                multiplicationStep = multiplicationStep * DECIMAL;
            } while (inCycle > DECIMAL);
        } else {
            multiplicationStep = 1;
        }
        firstDigit = inCycle;

        setFirstDigit(firstDigit);
        setLastDigit(lastDigit);
        setMultiplicationStep(multiplicationStep);
    }
}
