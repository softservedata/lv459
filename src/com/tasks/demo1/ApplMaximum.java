package com.tasks.demo1;

/*
 * Running application Maximum
 */

import com.tasks.demo.ConsoleOperation;

public class ApplMaximum {

	public static void main(String[] args) {
		
		Maximum max = new Maximum();
		int n = ConsoleOperation.readNumber();
		System.out.println(max.getNumBig(n));
		
	}
}
