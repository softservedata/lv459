package com.softserve.task1Tests;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.task1.NumContains;

/**
 * Test case for NumContains class method.
 * 
 * Test Design Techniques: Equivalence Partitioning
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class NumContainsTest {

	private NumContains nc = new NumContains();
	
	/*
	 * This test method throws false if the user insert negative number.
	 */
	@Test
	public void testIsConsist1() {
	
		boolean expected = false;
		boolean actual = nc.isConsist(-3);
		Assert.assertEquals("error_1", expected, actual);
	}
	
	/*
	 * This test method throws false if the user insert zero.
	 */
	@Test
	public void testIsConsist2() {
	
		boolean expected = false;
		boolean actual = nc.isConsist(0);
		Assert.assertEquals("error_2", expected, actual);
		
	}
	
	/*
	 * This test method confirms if there is digit 3 in the given number.
	 */
	@Test
	public void testIsConsist3() {
	
		boolean expected = true;
		boolean actual = nc.isConsist(3);
		Assert.assertEquals("error_3", expected, actual);
		
	}
}

