package com.softserve.testng;

import org.testng.annotations.Test;

public class TestNGTest10 {
	
	@Test(dependsOnMethods = { "method3" })
	public void method1() {
		System.out.println("This is method 1");
	}

	@Test(dependsOnMethods = { "method1", "method4" })
	public void method2() {
		System.out.println("This is method 2");
	}

	@Test
	public void method3() {
		System.out.println("This is method 3");
	}

	@Test
	public void method4() {
		System.out.println("This is method 4");
		throw new RuntimeException("hahaha");
	}

}
