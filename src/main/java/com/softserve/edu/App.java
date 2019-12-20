package com.softserve.edu;

public class App {
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Java";
		String s3 = new String("Java");
		//
		// Bad Practic
		System.out.println("s1 == s2: " + (s1 == s2)); // true
		System.out.println("s1 == s3: " + (s1 == s3)); // false
		//
		System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
		System.out.println("s1.equals(s3): " + s1.equals(s3)); // true
		//
		System.out.println("s1.compareTo(s2): " + s1.compareTo(s2)); // 0
		System.out.println("s1.compareTo(s3): " + s1.compareTo(s3)); // 0
		//
		System.out.println("s1.hashCode(): " + s1.hashCode());
		System.out.println("s2.hashCode(): " + s2.hashCode());
		System.out.println("s3.hashCode(): " + s3.hashCode());
	}
}
