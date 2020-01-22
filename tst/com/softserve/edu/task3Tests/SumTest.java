package com.softserve.edu.task3Tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.task3.Sum;

/**
 * Test case for Sum class method.
 * 
 * Test Design Techniques: Equivalence Partitioning and Boundary Values.
 * 
 * Equivalence Partitioning is checking lists with {0}, {1}, {2}, {>2} number of elements.
 * 
 * Boundary Values is checking lists with {0}, {1}, {2} number of elements.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class SumTest {

	private Sum sum = new Sum();
	
	/*
	 * This test method checks sum of empty list.
	 */
	@Test
	public void testSumList1() {
	
		List<Integer> list = Arrays.asList();
		Assert.assertEquals(sum.sumList(list), 0);
	
	}
	
	/*
	 * This test method checks sum of list with one element.
	 */
	@Test
	public void testSumList2() {
	
		List<Integer> list = Arrays.asList(1);
		Assert.assertEquals(sum.sumList(list), 1);
	
	}
	
	/*
	 * This test method checks sum of list with two elements.
	 */
	@Test
	public void testSumList3() {
	
		List<Integer> list = Arrays.asList(1, 2);
		Assert.assertEquals(sum.sumList(list), 3);
	
	}
	
	/*
	 * This test method checks sum of list with more than two elements.
	 */
	@Test
	public void testSumList4() {
	
		List<Integer> list = Arrays.asList(1, 2, 3);
		Assert.assertEquals(sum.sumList(list), 6);
	
	}
}
