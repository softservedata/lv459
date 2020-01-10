package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {

	@Test
	public void checkApp() {
		System.out.println("+++MyTest: checkApp()");
		Assert.assertTrue(true);
	}
}
