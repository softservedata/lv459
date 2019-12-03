package com.softserve.academy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Calc class. It gets first digit, last digit and multiplication
 * step of given number.
 */
public class CalcTest {

    /**
     * Getting first digit og given number.
     */
    @Test
    public void calculationsA() {
        Calc calculationsTest = new Calc();
        int input = 123456789;
        calculationsTest.calculations(input);
        Assert.assertEquals(calculationsTest.getFirstDigit(), 1);
    }

    /**
    Getting last digit of given number.
    */
    @Test
    public void calculationsB() {
        Calc calculationsTest = new Calc();
        int input = 123456789;
        calculationsTest.calculations(input);
        Assert.assertEquals(calculationsTest.getLastDigit(), 9);
    }

    /**
     * Getting multiplication step of given number.
     */
    @Test
    public void calculationsC() {
        Calc calculationsTest = new Calc();
        int input = 123456789;
        calculationsTest.calculations(input);
        Assert.assertEquals(calculationsTest.getMultiplicationStep(), 100000000);
    }
}