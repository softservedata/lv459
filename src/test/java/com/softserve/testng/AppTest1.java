package com.softserve.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest1 {

	@Test
	public void testApp1() {
		System.out.println("testApp1() start");
		// Read from POM.XML
		System.out.println("surefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
		System.out.println("selenium.version = " + System.getProperty("selenium.version"));
		System.out.println("temporary.variable = " + System.getProperty("temporary.variable"));
		//
		System.out.println("System.getenv().database.password = " + System.getenv().get("MY_PASSWORD"));
		System.out.println("is_jenkins = " + System.getenv().get("IS_JENKINS"));
		Assert.assertTrue(true);
	}

}
