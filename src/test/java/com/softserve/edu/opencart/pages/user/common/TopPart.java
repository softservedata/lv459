package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.WebDriver;

public abstract class TopPart {
	
	protected WebDriver driver;

	public TopPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic
}
