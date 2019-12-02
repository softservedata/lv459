package com.tasks.demo1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for Maximum class method.
 * 
 * Test Design Techniques: Equivalence Partitioning.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class MaximumTest {

	private Maximum max = new Maximum();
	
	/*
	 * This test method checks number with the biggest sum of dividers. 
	 */
	@Test
	public void testGetNumBig1() {
		
		Assert.assertEquals("error_1", max.getNumBig(-1), 0);
		Assert.assertEquals("error_2", max.getNumBig(0), 0);
		Assert.assertEquals("error_3", max.getNumBig(1), 1);
		Assert.assertEquals("error_4", max.getNumBig(10000), 9240);
		
	}
}
