package com.softserve.train3;

public class OOPSamples3 {
	public static void main(String... args) {
		Child3 child = new Child3();
		System.out.println("child.useF(): " + child.useF()); // Architecture Error
		System.out.println("child.useF2(): " + child.useF2()); // Architecture Error
		System.out.println("child.f(): " + child.f());
	}
}
