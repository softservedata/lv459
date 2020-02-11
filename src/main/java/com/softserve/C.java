package com.softserve;

public class C extends B {

	public void m1() {
		System.out.println("class C: m1()");
		//super.super.m1(); // Compile Error
		//super.m2(); // run static from B
		//m11(this); // Looping, run m1() from C
		//m12(); // Looping, run m1() from C
		//
		m11addition();  // One way Solution
		//getSuper().m1(); // Looping, run m1() from C
	}
}
