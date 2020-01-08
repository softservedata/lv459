package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSuccessAlertPage extends SearchSuccessPage {
	public static final String NOT_LOGGINED_ALERT_WISHLIST_MESSAGE = "You must login or create an account to save %s to your wish list!";
	//
	private WebElement alertMessage;
	private WebElement alertButton;
	
	public SearchSuccessAlertPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		alertMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
		alertButton = driver.findElement(By.cssSelector("div.alert.alert-success button"));
	}

	// Page Object

	// alertMessage
	public WebElement getAlertMessage() {
        return alertMessage;
    }

    public String getAlertMessageText() {
        return getAlertMessage().getText();
    }
    
	// alertButton
	public WebElement getAlertButton() {
        return alertButton;
    }

    public void clickAlertButton() {
        getAlertButton().click();
    }
	
	// Functional

	// Business Logic

}
