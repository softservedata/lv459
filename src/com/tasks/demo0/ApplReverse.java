package com.tasks.demo0;

import com.tasks.demo.ConsoleOperation;

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
