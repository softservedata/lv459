package com.softserve.edu.task3;

import java.util.List;

/**
 * The {@code Sum} calculates the sum of array.
 * 
 * @see java.util.List;
 * @version 13.0.1 15 Oct 2019
 */

public class Sum {
	
	/* Counts the sum of the given array */
	public int sumList(List<Integer> arr) {
		
		int result = 0;
		
		for (int i : arr) {
			result = result + i;
		}
		return result;
	}	
}
