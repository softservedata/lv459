package com.softserve.testng;

import org.testng.annotations.Test;

public class TestNGTest4 {

	@Test(timeOut = 1000)
	public void infinity() {
		System.out.println("Start");
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;
		long displayTime = startTime;
		while ((currentTime - startTime) < 1100) {
			if ((currentTime - displayTime) > 100) {
				displayTime = currentTime;
				System.out.println("working: " + (currentTime - startTime));
			}
			currentTime = System.currentTimeMillis();
		}
	}
}
