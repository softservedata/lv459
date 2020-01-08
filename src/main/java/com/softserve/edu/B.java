package com.softserve.edu;

public class B extends A {

	public B() {
		System.out.println("public B()");
	}
	
	public C login() {
		setKey(true);
		System.out.println("login() done");
		System.out.println("login() getKey() = " + getKey());
		return new C();
	}
	
}
