package com.softserve.edu.opencart.tests;

import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.user.HomePage;

public class CurrencyTest extends EpizyUserTestRunner {

	@Test
	public void checkChangeCurrency() throws Exception {
		// Steps
		HomePage homepage = loadApplication()
				.chooseCurrency(Currencies.POUND_STERLING);
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		System.out.println("Actual: " + homepage.getCurrencyText());
		System.out.println("Expected: " + Currencies.POUND_STERLING.toString());
		//Assert.assertTrue("Currency Error",
		//		homepage.getCurrencyText().contains(Currencies.POUND_STERLING.toString()));
		Thread.sleep(2000); // For Presentation Only
	}
}
