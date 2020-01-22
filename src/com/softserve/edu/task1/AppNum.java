package com.softserve.edu.task1;

/*
 * Running application NumContains.
 */

public class AppNum {

	public static void main(String[] args) {
		
		SquaredNum sn = new SquaredNum();
		NumContains nc = new NumContains();
		
		int n = ConsoleOperation.readNaturalNumber();	
		int squared = sn.getSquared(n);
		nc.isConsist(squared);
	}
}
