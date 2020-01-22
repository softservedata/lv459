package com.softserve.task1Tests;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.task1.SquaredNum;

/**
 * Test case for SquaredNum class method.
 * 
 * Test Design Techniques: Positive Boundary Values.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class SquaredNumTest {
	
	private SquaredNum sn = new SquaredNum();
	
	/*
	 * This test method checks how zero insert will be handled.
	 */
	@Test
	public void testGetSquared1() {
		
		int expected = 0;
		int actual = sn.getSquared(0);
		Assert.assertEquals("error_1", expected, actual);
		
	}
	
	/*
	 * This test method checks how one insert will be handling.
	 */
	@Test
	public void testGetSquared2() {
		
		int expected = 1;
		int actual = sn.getSquared(1);
		Assert.assertEquals("error_2", expected, actual);
		
	}
	
	/*
	 * This test method checks is the number getting squared.
	 */
	@Test
	public void testGetSquared3() {
		
		int expected = 4;
		int actual = sn.getSquared(2);
		Assert.assertEquals("error_3", expected, actual);
		
	}
}
