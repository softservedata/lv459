package com.softserve.edu.opencart.pages.user.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BreadCrumbPart extends TopPart {

    private WebElement breadCrumb;
    //
    private List<WebElement> breadCrumbComponents;
	
	public BreadCrumbPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic

}
