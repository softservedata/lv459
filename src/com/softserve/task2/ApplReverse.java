package com.softserve.task2;

import com.softserve.task1.ConsoleOperation;

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
