package com.softserve.testng;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstNg {

	//private boolean isTestSuccessful = false;
	//private String testName = "";
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite class FirstNg beforeSuite()");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("@AfterSuite class FirstNg afterSuite()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t@BeforeTest class FirstNg beforeTest()");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("\t@AfterTest class FirstNg afterTest()");
	}

	@BeforeClass
	//public void beforeClass() {
	public void beforeClass(ITestContext context) {
		//HashMap<String, String> parameters = new HashMap<>(context.getCurrentXmlTest().getAllParameters());
		for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
			System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
		}
		System.out.println("\t\t@BeforeClass class FirstNg beforeClass()");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("\t\t@AfterClass class FirstNg afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t@BeforeMethod class FirstNg beforeMethod()");
		//isTestSuccessful = false;
	}

//	@BeforeMethod
//	public void beforeMethod2() {
//		System.out.println("\t\t\t@BeforeMethod class FirstNg beforeMethod2()");
//	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("\t\t\t@AfterMethod class FirstNg afterMethod()");
		//if (!isTestSuccessful) {
//		if (!result.isSuccess()) {
			//System.out.println("Test " + testName + " ERROR");
//			System.out.println("Test " + result.getName() + " ERROR");
			// Take Screenshot, save sourceCode, save to log, prepare report, Return to previous state, logout, etc.
//		}
		//throw new RuntimeException("@AfterMethod hahaha");
	}

	//@Test
	public void zero() {
		System.out.println("\t\t\t\t@Test class FirstNg zero()");
	}

	@Test
	public void one() {
		//testName = "one()";
		System.out.println("\t\t\t\t@Test class FirstNg one()");
//		if (!getClass().getName().isEmpty()) {
//			throw new RuntimeException("hahaha @Test");
//		}
		//isTestSuccessful = true;
	}

	@Test
	public void two() {
		//testName = "two()"; 
		System.out.println("\t\t\t\t@Test class FirstNg two()");
		//isTestSuccessful = true;
	}

}
