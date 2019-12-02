package com.tasks.demo1;

/**
 * The {@code Maximum} class finds the number with the biggest sum of dividers.
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class Maximum {
	
	/* Finds the number with the biggest sum of dividers */
	public int getNumBig(int n) {
	
		Sum sum = new Sum();
		Dividers div = new Dividers();
		int maxSum = 0;
		int numberWithBiggestDividersSum = 0;
	
		for (int i = 1; i <= n; i++) {
			int currentSum = sum.sumList(div.getDividers(i));		
			
			if (maxSum < currentSum) {
				maxSum = currentSum;
				numberWithBiggestDividersSum = i;
			}
		}
		return numberWithBiggestDividersSum;
	}
	
}

