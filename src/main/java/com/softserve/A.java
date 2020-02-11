package com.softserve;

public class A {
	public int i; // =0 by default
	private int k = 111; // =0 by default

	public A() {
		//System.out.println("class A: Constructor");
		System.out.println("class A: Constructor, k = " + k);
		k = 123;
	}

	public A(int i) {
		this.i = i;
		System.out.println("class A: Constructor");
	}

	public int getK() {
		System.out.println("class A: getK()");
		return k;
	}

	//public void m1() {
	//protected void m1() {
	void m1() {
		int temp; // undefined
		i = i + 1;
		System.out.println("class A: m1()");
	}

	protected static void m11(A a) {
		System.out.println("class A: m11()");
		//a.m1(); // Looping, run m1() from C
	}

	public void m12() {
		System.out.println("class A: m12()");
		//m1(); // Looping, run m1() from C
		//this.m1(); // Looping, run m1() from C
		//A.this.m1(); // Looping, run m1() from C
	}

	public static void m2() {
		System.out.println("class A: m2()");
	}

	public void m3() {
		System.out.println("class A: m3()");
	}

	public A getThis() {
		return this;
	}

}
