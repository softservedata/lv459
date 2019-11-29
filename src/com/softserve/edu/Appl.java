package com.softserve.edu;

public class Appl {
	private int k;

	private void myprn() {
		System.out.println("myprn(), k= " + k);
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		Appl app = new Appl();
		app.k = 123;
		//
		Appl app2 = new Appl();
		app2.k = 56;
		//
		app.myprn();
		app2.myprn();
		int i = 10;
		int j = 22;
		int k = i++ + j;
		System.out.println("k=" + k + " i=" + i);
		//
		String s = "abc";
		s = s + i;
		System.out.println("s= " + s);
	}

}
