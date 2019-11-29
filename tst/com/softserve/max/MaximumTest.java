package com.softserve.max;

import org.junit.Assert;
import org.junit.Test;

public class MaximumTest {

	@Test
	public void testMax1() {
		Maximum max = new Maximum();
		double actual;
		double expected;
		//
		actual = max.getMax(4, 4);
		expected = 4;
		Assert.assertEquals("my_error1", expected, actual, 0.001);
	}

	@Test
	public void testMax2() {
		Maximum max = new Maximum();
		double actual;
		double expected;
		//
		actual = max.getMax(5, 4);
		expected = 5;
		Assert.assertEquals("my_error2", expected, actual, 0.001);
	}

	@Test
	public void testMax3() {
		Maximum max = new Maximum();
		double actual;
		double expected;
		//
		actual = max.getMax(4, 5);
		expected = 5;
		Assert.assertEquals("my_error3", expected, actual, 0.001);
	}

}
