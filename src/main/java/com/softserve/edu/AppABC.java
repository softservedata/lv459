package com.softserve.edu;

public class AppABC {
	public static void main(String[] args) {
		B b = new B();
		System.out.println("after new; b.getKey() = " + b.getKey());
		C c = b.login();
		System.out.println("after login; c.getKey() = " + c.getKey() + "  b.getKey() = " + b.getKey());
		b = c.logout();
		System.out.println("after logout; b.getKey() = " + b.getKey());
	}
}
