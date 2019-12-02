package com.tasks.demo0;

/*
 * Running application Reverse
 */

import com.tasks.demo.ConsoleOperation;

public class ApplReverse {

	public static void main(String[] args) {
		
		NumReverse nr = new NumReverse();
		int n = ConsoleOperation.readNumber();
		nr.getTurned(n);
	}

}
