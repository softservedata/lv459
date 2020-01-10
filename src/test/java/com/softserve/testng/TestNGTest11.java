package com.softserve.testng;

import org.testng.annotations.Test;

public class TestNGTest11 {
	
	@Test(priority = 3)
	public void method1() {
		System.out.println("This is method 1");
	}

	@Test(priority = 5)
	public void method2() {
		System.out.println("This is method 2");
	}

	@Test(priority = 1)
	public void method3() {
		System.out.println("This is method 3");
	}

	@Test(priority = 3)
	public void method4() {
		System.out.println("This is method 4");
		throw new RuntimeException("hahaha");
	}

}
