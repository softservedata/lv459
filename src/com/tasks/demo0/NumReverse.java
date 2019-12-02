package com.tasks.demo0;

/**
 * The {@code NumReverse} class changes the order of the given number.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class NumReverse {
	
	/* This method returns number in reverse */
	public int getTurned(int n) {
		
		String result = "";
		
		while (n > 0) {
			result = result + (n % 10);
			n = n / 10; 
		}
		if (result.length() == 0) {
			result = "0";
		}
		return Integer.parseInt(result);
	}

}
