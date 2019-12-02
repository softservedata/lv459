package com.tasks.demo1;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for Dividers class method.
 * 
 * Test Design Techniques: Equivalence Partitioning
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class DividersTest {
	
	private Dividers div = new Dividers();
	
	/*
	 * This test method checks number with more than two dividers.
	 */
	@Test
	public void testGetDividers1() {
		
		List<Integer> expected = Arrays.asList(1, 2, 4);
		List<Integer> actual = div.getDividers(4);
		Assert.assertEquals("error_1", expected, actual); 
		
	}
	
	/*
	 * This test method checks simple number with two dividers.
	 */
	@Test
	public void testGetDividers2() {
		
		List<Integer> expected = Arrays.asList(1, 2);
		List<Integer> actual = div.getDividers(2);
		Assert.assertEquals("error_2", expected, actual); 
		
	}
	
	/*
	 * This test method checks simplest number with one divider.
	 */
	@Test
	public void testGetDividers3() {
		
		List<Integer> expected = Arrays.asList(1);
		List<Integer> actual = div.getDividers(1);
		Assert.assertEquals("error_3", expected, actual);
		
	}
	
	/*
	 * This test method checks negative scenario when user insert 0. 
	 */
	@Test
	public void testGetDividers4() {
		
		List<Integer> expected = Arrays.asList();
		List<Integer> actual = div.getDividers(0);
		Assert.assertEquals("error_4", expected, actual);
		
	}
	
	/*
	 * This test method checks scenario when user insert negative number. 
	 */
	@Test
	public void testGetDividers5() {
		
		List<Integer> expected = Arrays.asList();
		List<Integer> actual = div.getDividers(-1);
		Assert.assertEquals("error_5", expected, actual);
		
	}
}
