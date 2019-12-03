package com.softserve.academy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for algorithm methods for solving task 88D.
 */
public class Task88DTest {

    /**
     * Testing complete algorithm for solving task 88D
     */
    @Test
    public void doTask88D() {
        Task88D testTask = new Task88D();
        NumberDTO testNumberDTO = new NumberDTO(123);
        testTask.doTask88D(testNumberDTO);
        Assert.assertEquals(testNumberDTO.getResultNumber(), 11231);
    }

    /**
     * Testing method for adding 1 at the beginning and 1 at the end of given
     * number.
     */
    @Test
    public void add1EndAndBeginning() {
        Task88D testTask = new Task88D();
        NumberDTO testNumberDTO = new NumberDTO(123);
        testTask.doTask88D(testNumberDTO);
        Assert.assertEquals(testNumberDTO.getResultNumber(), 11231);
    }
}