package com.softserve;

public class B extends A {
	public int j;

	// Java Compiler insert default constructor public B(){}
	public B() {
		System.out.println("class B: Constructor");
		j = 121;
	}

	public void m1() {
		System.out.println("class B: m1()");
		//m1(); // Recursive 
		super.m1();
	}
	
	public void m11addition() {
		System.out.println("class B: m11()");
		super.m1();
	}

	public static void m2() {
		System.out.println("class B: m2()");
	}

	public static void m11(A a) {
		System.out.println("class B: m11()");
		//a.m1(); // Looping, run m1() from C
	}
	
//	private void m3() { // Architecture Error
//		System.out.println("class B: m3()");
//	}
	
	public A getSuper() {
		//return super;
		return super.getThis();
	}

}
