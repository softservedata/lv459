package com.softserve.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondNg {

//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("@BeforeSuite class SecondNg beforeSuite()");
//	}

//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("@AfterSuite class SecondNg afterSuite()");
//	}

//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("\t@BeforeTest class SecondNg beforeTest()");
//	}

//	@AfterTest
//	public void afterTest() {
//		System.out.println("\t@AfterTest class SecondNg afterTest()");
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\t@BeforeClass class SecondNg beforeClass()");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\t\t@AfterClass class SecondNg afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t@BeforeMethod class SecondNg beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t@AfterMethod class SecondNg afterMethod()");
	}

	@Test
	public void three() {
		System.out.println("\t\t\t\t@Test class SecondNg three()");
	}

	@Test
	public void four() {
		System.out.println("\t\t\t\t@Test class SecondNg four()");
	}

}
