package com.softserve.edu.task3Tests;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.task3.Maximum;

/**
 * Test case for Maximum class method.
 * 
 * Test Design Techniques: Equivalence Partitioning and Boundary values.
 * 
 * Equivalence Partitioning is checking next numbers {negative, 0}; {1}; {2}.
 * 
 * Boundary values is checking next numbers {0}; {1}; {2}.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class MaximumTest {

	private Maximum max = new Maximum();
	
	/*
	 * This test method checks scenario when user insert negative number.
	 */
	@Test
	public void testGetNumBig1() {
		
		int expected = 0;
		int actual = max.getNumBig(-1);
		Assert.assertEquals(expected, actual);
	
	}
	
	/*
	 * This test method checks negative scenario when user insert 0. 
	 */
	@Test
	public void testGetNumBig2() {
		
		int expected = 0;
		int actual = max.getNumBig(0);
		Assert.assertEquals(expected, actual);
		
	}
	
	/*
	 * This test method checks number with one divider.
	 */
	@Test
	public void testGetNumBig3() {
		
		int expected = 1;
		int actual = max.getNumBig(1);
		Assert.assertEquals(expected, actual);
		
	}
	
	/*
	 * This test method checks number with two dividers.
	 */
	@Test
	public void testGetNumBig4() {
		
		int expected = 2;
		int actual = max.getNumBig(2);
		Assert.assertEquals(expected, actual);
		
	}
}

