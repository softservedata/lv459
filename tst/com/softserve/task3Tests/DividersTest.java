package com.softserve.task3Tests;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.softserve.task3.Dividers;

/**
 * Test case for Dividers class method.
 * 
 * Test Design Techniques: Equivalence Partitioning and Boundary Values.
 * 
 * Equivalence Partitioning is checking next values {negative, 0}; {1}; 
 * {2, 3, 5 (simple numbers with two dividers)}; {4, 6 (numbers with more than 2 dividers)}.
 * 
 * Boundary Values is checking values {0}, {1}, {2}.
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
		Assert.assertEquals(expected, actual); 
		
	}
	
	/*
	 * This test method checks simple number with two dividers.
	 */
	@Test
	public void testGetDividers2() {
		
		List<Integer> expected = Arrays.asList(1, 2);
		List<Integer> actual = div.getDividers(2);
		Assert.assertEquals(expected, actual); 
		
	}
	
	/*
	 * This test method checks simplest number with one divider.
	 */
	@Test
	public void testGetDividers3() {
		
		List<Integer> expected = Arrays.asList(1);
		List<Integer> actual = div.getDividers(1);
		Assert.assertEquals(expected, actual);
		
	}
	
	/*
	 * This test method checks negative scenario when user insert 0. 
	 */
	@Test
	public void testGetDividers4() {
		
		List<Integer> expected = Arrays.asList();
		List<Integer> actual = div.getDividers(0);
		Assert.assertEquals(expected, actual);
		
	}
	
	/*
	 * This test method checks scenario when user insert negative number. 
	 */
	@Test
	public void testGetDividers5() {
		
		List<Integer> expected = Arrays.asList();
		List<Integer> actual = div.getDividers(-1);
		Assert.assertEquals(expected, actual);
		
	}
}
