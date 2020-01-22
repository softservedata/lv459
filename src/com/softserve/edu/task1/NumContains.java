package com.softserve.edu.task1;

/**
 * The {@code NumContains} class finds is the given number contains digit 3 or not.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class NumContains {
	
	/* This constant contains digit we're looking */
	private static final int DIGIT_FOR_LOOKING = 3;
	
	/* Finds digit 3 in the given number */
	public boolean isConsist(int n) {
		
		boolean isContains = false; 
		
		while (n > 0) {
			if (n % 10 == DIGIT_FOR_LOOKING) {
				isContains = true;
				break;
			}
			n = n / 10;
		}
		return isContains;
	}	
}
