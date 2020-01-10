package com.softserve.testng;

import java.util.Vector;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest7 {

	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() {
		return new Object[][] {
				{ Vector.class, new String[] { "java.util.AbstractList", "java.util.AbstractCollection" } },
				{ String.class, new String[] { "11", "222" } },
				{ Integer.class, new String[] { "333", "44", "55" } } };
	}

	@Test(dataProvider = "Data-Provider-Function")
	public void parameterIntTest(Class<?> clzz, String[] numbers) {
		System.out.println("clzz= " + clzz.getName());
		for (String current : numbers) {
			System.out.println("current is: " + current);
		}
	}
}
