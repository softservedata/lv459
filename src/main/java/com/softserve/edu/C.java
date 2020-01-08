package com.softserve.edu;

public class C extends A {

	public C() {
		System.out.println("public C()");
	}
	
	public B logout() {
		setKey(false);
		System.out.println("logout() done");
		return new B();
	}
	
}
