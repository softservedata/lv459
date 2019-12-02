package com.tasks.demo;

/*
 * Running application NumContains
 */

public class AppNum {

	public static void main(String[] args) {
		
		SquaredNum sn = new SquaredNum();
		NumContains nc = new NumContains();
		
		int n = ConsoleOperation.readNumber();	
		int squared = sn.getSquared(n);	
		System.out.println(nc.isConsist(squared));
	}
}
