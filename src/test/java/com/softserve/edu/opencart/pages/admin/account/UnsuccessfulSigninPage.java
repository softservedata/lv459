package com.softserve.edu.opencart.pages.admin.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulSigninPage extends SigninPage {

	public static final String EXPECTED_SIGNIN_MESSAGE = "No match for Username and/or Password.";
	//
	private WebElement alertWarning;

	public UnsuccessfulSigninPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
	}

	// Page Object

	// alertWarning
	public WebElement getAlertWarning() {
		return alertWarning;
	}

	public String getAlertWarningText() {
		return getAlertWarning().getText();
	}

	// Functional

	// Business Logic

}
