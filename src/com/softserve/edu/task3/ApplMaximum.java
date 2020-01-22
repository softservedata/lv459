package com.softserve.edu.task3;

import com.softserve.edu.task1.ConsoleOperation;

/*
 * Running application Maximum.
 */

public class ApplMaximum {

	public static void main(String[] args) {
		
		Maximum max = new Maximum();
		int n = ConsoleOperation.readNaturalNumber();
		System.out.println(max.getNumBig(n));
		
	}
}
