package com.softserve.edu.task2;

import com.softserve.edu.task1.ConsoleOperation;

/*
 * Running application NumReverse.
 */

public class ApplReverse {

	public static void main(String[] args) {
		
		NumReverse nr = new NumReverse();
		int n = ConsoleOperation.readNaturalNumber();
		nr.getTurned(n);
	}
}
