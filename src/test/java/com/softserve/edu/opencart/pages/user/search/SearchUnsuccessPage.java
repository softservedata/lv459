package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchUnsuccessPage extends SearchCriteriaPart {
	public static final String NO_PRODUCT_MESSAGE = "There is no product that matches the search criteria.";
	//
	private WebElement noProductMessage;
	
	public SearchUnsuccessPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		noProductMessage = driver.findElement(By.cssSelector("input#button-search+h2+p"));
	}

	// Page Object

	// noProductMessage
	public WebElement getNoProductMessage() {
        return noProductMessage;
    }

    public String getNoProductMessageText() {
        return getNoProductMessage().getText();
    }
    
	// Functional

	// Business Logic
    
}
