package com.softserve.edu.opencart.pages.admin.currencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class CurrenciesPage extends LeftMenuPart {
	
	public static final String EXPECTED_TITLE_MESSAGE = "Currencies";
	//
	private WebElement title;

	public CurrenciesPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		title = driver.findElement(By.cssSelector("div.page-header h1"));
	}

	// Page Object

	// title
	public WebElement getTitle() {
		return title;
	}

	public String getTitleText() {
		return getTitle().getText();
	}

	// Functional

	// Business Logic

}
