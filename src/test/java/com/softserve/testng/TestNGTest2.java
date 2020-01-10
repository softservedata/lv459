package com.softserve.testng;

import org.testng.annotations.Test;

public class TestNGTest2 {
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
		System.out.println(i);
	}
	
    @Test(enabled=false)
    public void enabledFalse( ) {
      System.out.println("Method is not ready yet");
    }

}
