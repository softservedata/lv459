package com.softserve;

public class C extends B {

	public void m1() {
		System.out.println("class C: m1()");
		//super.m2(); // run static from B
		//m11(this); // Looping, run m1() from C
		//m12(); // Looping, run m1() from C
		m11();
	}
}
