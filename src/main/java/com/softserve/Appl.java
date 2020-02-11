package com.softserve;

import java.util.Calendar;

public class Appl {
	
	public void w(A a) {
		Calendar c;
		System.out.println("w(A a)");
	}

	public void w(B b) {
		System.out.println("w(B b)");
	}

//	public void w(B2 b) { // The method w(A) is ambiguous for the type Appl
//		System.out.println("w(B2 b)");
//	}
	
	public void w2(Object o) {
		System.out.println("w2(Object o)");
	}
	
	public void w2(IllegalArgumentException e) {
		System.out.println("w2(IllegalArgumentException e)");
	}

	public void w2(Exception e) {
		System.out.println("w2(Exception e)");
	}

	public void w2(RuntimeException e) {
		System.out.println("w2(RuntimeException e)");
	}

	public void w3(Object i) {
		System.out.println("w2(int i)");
	}

	public void w3(String s) {
		System.out.println("String s");
	}

	public static void main(String[] args) {
		/*
		B b = new B();
		// 1. allocate memory
		// 2. create object
		// 3. fill fields
		// 4. setup virtual method table
		//
		// b.k; // Error, k is private.
		System.out.println("b.getK() = " + b.getK());
		//
		int l = 2;
		double d = -1.1;
		//
		//d = l; // ok
		//System.out.println("d = " + d);
		//l = d; // error
		l = (int)d; // ok
		System.out.println("l = " + l); // -1
		//
		//B b = new A(); // error
//		A a1 = new A();
		//B b = a1; // error
//		B b0 = (B)a1; // No Compile Error, but Runtime Error
//		System.out.println("b0.j = " + b0.j); // runtime error
		//
		//
		A a = new B();
		a.m1(); // from class B 
		//((A)a).m1(); // from class B, not form A
		//
		a.m2(); // from class A
//		A.m2();
//		B.m2();
		//
		*/
		A c = new C();
//		c.m2(); // Run m2 from B
		c.m1();
		//
		/*
		Appl appl = new Appl();
		//A a2 = new A(); // w(A a)
		//A a2 = new B(); // w(A a)
		//B a2 = new B(); // w(B b)
		//C a2 = new C(); // w(B b)
		//appl.w(a2);
		//appl.w(null); // w(B b)
		//appl.w2(null); // w2(RuntimeException e); w2(IllegalArgumentException e)
		appl.w3(null);
		*/
	}
}
