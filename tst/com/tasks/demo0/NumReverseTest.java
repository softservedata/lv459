package com.tasks.demo0;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for NumReverse class method.
 * 
 * Test Design Techniques: Equivalence Partitioning
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class NumReverseTest {

	private NumReverse nr = new NumReverse();
	
	/*
	 * This test method reverse the given number.
	 */
	@Test
	public void testGetTurned1() {
		
		int expected = 123;
		int actual = nr.getTurned(321);	
		Assert.assertEquals("error_1", expected, actual);
		
	}
}
