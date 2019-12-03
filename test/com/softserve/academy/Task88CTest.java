package com.softserve.academy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for algorithm methods for solving task 88C.
 */
public class Task88CTest {

    /**
     * Testing complete algorithm for solving task 88C
     */
    @Test
    public void doTask88c() {
        Task88C testTask = new Task88C();
        NumberDTO testNumberDTO = new NumberDTO();
        testNumberDTO.setInputNumber(123);
        testTask.doTask88c(testNumberDTO);
        Assert.assertEquals(testNumberDTO.getResultNumber(), 321);
    }

    /**
     * Test for replacing last and first digit in the given number.
     */
    @Test
    public void replaceLastAndFirstNumber() {
        Task88C testTask = new Task88C();
        NumberDTO testNumberDTO = new NumberDTO();
        testNumberDTO.setInputNumber(123);
        testTask.doTask88c(testNumberDTO);
        Assert.assertEquals(testNumberDTO.getResultNumber(), 321);
    }
}
