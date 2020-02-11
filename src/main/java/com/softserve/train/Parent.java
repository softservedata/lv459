package com.softserve.train;

public class Parent {
	
	//protected int f() {
	//private final int f() {
	int f() {
		return 1;
	}

	public int useF() {
		return f();
	}
}
