package com.tasks.demo1;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for Sum class method.
 * 
 * Test Design Techniques: Equivalence Partitioning
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class SumTest {

	private Sum sum = new Sum();
	
	@Test
	public void testSumList1() {
	
		List<Integer> list = Arrays.asList(1, 2);
		Assert.assertEquals("error_1", sum.sumList(list), 4);
//		EP 0,1,2+ elements
//		BV 0,1,2
		
	}
}
