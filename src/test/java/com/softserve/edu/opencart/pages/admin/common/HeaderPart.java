package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPart {

	protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    protected final String TAG_ATTRIBUTE_CLASS = "class";
    //
	protected WebDriver driver;
	//
	private WebElement logo;

	public HeaderPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
		logo = driver.findElement(By.cssSelector("#header a[href*='route=common/dashboard']"));
	}

	// Page Object

	// logo
	public WebElement getLogo() {
		return logo;
	}

	public void clickLogo() {
		getLogo().click();
	}
	
	// Functional

	// Business Logic

}
