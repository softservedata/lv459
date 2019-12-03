package com.softserve.academy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for checking if algorithm methods will work correctly.
 */
public class CheckNumberValidityTest {

    /**
     * Tests if the number after replacement of first and last digits will be
     * in Integer range
     */
    @Test
    public void inRangeReplacementCheck() {
        CheckNumberValidity checkNumberValidity = new CheckNumberValidity();
        boolean testBoolean = checkNumberValidity.inRangeAdd11Check(13);
        Assert.assertTrue(testBoolean);
    }

    /**
     * Tests if the number after adding 1 at the begging and 1 in the end
     * will be in Integer range
     */
    @Test
    public void inRangeAdd11Check() {
        CheckNumberValidity checkNumberValidity = new CheckNumberValidity();
        boolean testBoolean = checkNumberValidity.inRangeAdd11Check(13);
        Assert.assertTrue(testBoolean);
    }
}