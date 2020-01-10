package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FirstTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite beforeSuite()");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("@AfterSuite afterSuite()");
	}

	@AfterSuite
	public void afterSuite2() {
		System.out.println("@AfterSuite afterSuite2()");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("\t@BeforeTest beforeTest()");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("\t@AfterTest afterTest()");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\t@BeforeClass beforeClass()");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("\t\t@AfterClass afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t@BeforeMethod beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t@AfterMethod afterMethod()");
		//throw new RuntimeException("hahaha");
	}
	
	@Test
	public void test1() {
		System.out.println("\t\t\t\t@Test test1()");
	}

	//@Test
	public void test2() {
		System.out.println("\t\t\t\t@Test test2()");
	}

}
