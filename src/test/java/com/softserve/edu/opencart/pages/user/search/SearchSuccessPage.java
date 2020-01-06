package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;

public class SearchSuccessPage extends SearchCriteriaPart {

	private ProductsDisplayComponent productsDisplay;

	public SearchSuccessPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		productsDisplay = new ProductsDisplayComponent(driver);
	}

	// Page Object

	// productsDisplay

	public ProductsDisplayComponent getProductsDisplay() {
		return productsDisplay;
	}

	// Functional

	// Business Logic

	public SearchSuccessPage chooseCurrency(Currencies currency) {
		clickCurrencyByPartialName(currency);
		return new SearchSuccessPage(driver);
	}
	
	// TODO Use Enum
	public SearchSuccessPage sortProductsByCriteria(String text)
    {
		//productsDisplay.setInputSort(text);
        return new SearchSuccessPage(driver);
    }
    
    // TODO Use Enum
    public SearchSuccessPage showProductsByCount(String text)
    {
    	//productsDisplay.setInputLimit(text);
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessAlertPage AddToWishButtonByName(Product product) {
    	productsDisplay.clickProductComponentAddToWishButtonByName(product.getName());
    	return new SearchSuccessAlertPage(driver);
    }

    public ProductInfoPage gotoProductInfo(Product product) {
    	getProductsDisplay()
    		.getProductComponentByName(product)
    		.clickName();
    	return new ProductInfoPage(driver);
    } 

}
