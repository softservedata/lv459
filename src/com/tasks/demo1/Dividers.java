package com.tasks.demo1;

import java.util.List;
import java.util.ArrayList;

/**
 * The {@code Dividers} class defines dividers of the num.
 * 
 * @see import java.util.List;
 * @see import java.util.ArrayList;
 * @version 13.0.1 15 Oct 2019
 */


public class Dividers {
	
	/* Defines dividers of the given number */
	public List<Integer> getDividers(int number){
		
		List<Integer> result = new ArrayList<Integer>();
	
		for (int i = 1; i <= number; i++) {
				
			if (number % i == 0) {
				result.add(i);
			}
		}
		return result;
	}
	
}
