package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;

public class SearchTest extends EpizyUserTestRunner {

	@Test
	public void checkSearch() {
		// Test Data
		// SearchFilter searchFilter
		Product validProduct = ProductRepository.getMacBook();
		Currencies currency = Currencies.EURO;
		//
		// Steps
		SearchSuccessPage searchSuccessPage = loadApplication().successfulSearch(validProduct).chooseCurrency(currency);
		presentationSleep();
		ProductComponent actualProductComponent = searchSuccessPage.getProductsDisplay()
				.getProductComponentByName(validProduct);
		presentationSleep();
		//
		// Check
		Assert.assertTrue(actualProductComponent.getPriceText().contains(validProduct
				// .getPriceDollarExTax()));
				.getPrice(currency)));
		presentationSleep();
		//
		// TODO
		// Continue Searching. Use SearchCriteria from SearchCriteriaPart
		//
		// Return to Previous State
		HomePage homePage = searchSuccessPage.gotoHomePage();
		//
		// Check (optional)
		Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
	}

}
