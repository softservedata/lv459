package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Test.
     */
    @Test
    public void checkApp() {
        System.out.println("AppTest: checkApp()");
        Assert.assertTrue(true);
    }
    
    @Test
    public void checkApp2() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        Assert.assertTrue(true);
    }
}
