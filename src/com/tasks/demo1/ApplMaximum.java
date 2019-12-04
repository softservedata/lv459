package com.tasks.demo1;

import com.tasks.demo.ConsoleOperation;

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
