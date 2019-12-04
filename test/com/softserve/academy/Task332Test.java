package com.softserve.academy;

import org.junit.Assert;
import org.junit.Test;

/** Tests for algorithm methods for solving task 88D. */
public class Task332Test {

    /** Testing complete method for getting Legrange theorem.
     * Here all 'if's are working = decision testing.
     * Equivalence partition.
     */
    @Test
    public void calculateLergangeFromNaturalNumber() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = new NumberDTO(95);
        testTask.calculateLergange(testNumberDTO);
        Integer[] assertList = {9, 3, 2, 1};
        Assert.assertEquals(testNumberDTO.getLegrange(), assertList);
    }

    /** Test if method can work with null object. */
    @Test(expected = RuntimeException.class)
    public void checkIfInputObjectIsNull() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = null;
        testTask.calculateLergange(testNumberDTO);
    }

    /** Test if method can work with negative numbers as input.
     * Equivalence partition.
     */
    @Test(expected = RuntimeException.class)
    public void checkIfAlgorithmCoverNegativeNumber() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = new NumberDTO(-9);
        testTask.calculateLergange(testNumberDTO);
    }

    /** Test if method can work with 0 as input.
     * Equivalence partition + Boundary value.
     */
    @Test(expected = RuntimeException.class)
    public void checkIfAlgorithmWorkZeroAsInputNumber() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = new NumberDTO(0);
        testTask.calculateLergange(testNumberDTO);
    }

    /** Test if method can work with Integer_MAX+1 as input.
     * Boundary value.
     */
    @Test(expected = RuntimeException.class)
    public void checkIfAlgorithmWorkIntegerMaxPlus1InputNumber() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = new NumberDTO(Integer.MAX_VALUE+1);
        testTask.calculateLergange(testNumberDTO);
    }

    /** Testing complete method for getting Legrange theorem.
     * Boundary value.*/
    @Test
    public void calculateLergangeFromIntegerMax() {
        Task332 testTask = new Task332();
        NumberDTO testNumberDTO = new NumberDTO(Integer.MAX_VALUE);
        testTask.calculateLergange(testNumberDTO);
        Integer[] assertList = {46339, 425, 10, 1};
        Assert.assertEquals(testNumberDTO.getLegrange(), assertList);
    }

    /** Test for getting closest int of sqrt of given number. */
    @Test
    public void getSqrtFromNumber() {
        Task332 testTask = new Task332();
        Assert.assertEquals(testTask.getSqrtFromNumber(9), 3);
    }

    /** Test for checking if calculated number make Legrange theorem. */
    @Test
    public void checkIfFiguresMakeLegrange() {
        Task332 testTask = new Task332();
        Assert.assertTrue(testTask.
                checkIfFiguresMakeLegrange(4, 3, 2, 1, 30));
    }
}
