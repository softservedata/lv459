package com.softserve.edu;

public class A {

	protected boolean key;
	
	public A() {
		key = false;
		System.out.println("public A()");
	}

	public boolean getKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

}
