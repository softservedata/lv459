package com.softserve.training;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass done for task1");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass done");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\t@Before done");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\t@After done");
	}

	//@Test
	public void testAdd0() {
		System.out.println("\t\t@Test testAdd0() start");
		// int i = 1 / 0;
		double i = 1 / 0.0;
		System.out.println("\t\t\ti=" + i);
		//if (i > 0) {
		if (i > Double.MAX_VALUE) {
			throw new RuntimeException("ha-ha-ha");
		}
		System.out.println("\t\t\ti=" + i);
		// fail("Not yet implemented");
	}

	@Test
	public void testAdd1() {
		System.out.println("\t\t\t@Test testAdd1() start");
		//
		Calc calc = new Calc();
		double actual;
		double expected;
		//
		actual = calc.add(4, 4);
		expected = 8;
		Assert.assertEquals("my_error", expected, actual, 0.001);
	}

	@Test
	public void testAdd2() {
		System.out.println("\t\t\t@Test testAdd2() start");
		//
		Calc calc = new Calc();
		double actual;
		double expected;
		//
		actual = calc.add(16, 4);
		expected = 20;
		Assert.assertEquals("my_error2", expected, actual, 0.001);
	}

	@Test
	public void testDiv1() {
		System.out.println("\t\t\t@Test testDiv1() start");
		//
		Calc calc = new Calc();
		double actual;
		double expected;
		//
		actual = calc.div(16, 4);
		expected = 4;
		Assert.assertEquals("my_error3", expected, actual, 0.001);
		// fail("Not yet implemented");
	}

	@Test
	public void testDiv2() {
		System.out.println("\t\t\t@Test testDiv2() start");
		Calc calc = new Calc();
		double actual;
		double expected;
		//
		actual = calc.div(18, 4);
		expected = 4.5;
		Assert.assertEquals("my_error4", expected, actual, 0.001);
		// fail("Not yet implemented");
	}

}
