package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.common.TopPart;

public class HomePage extends TopPart {

	private WebElement slideshow0;
	//
	private ProductsContainerComponent productsContainerComponent;

	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		slideshow0 = driver.findElement(By.id("slideshow0"));
		productsContainerComponent = new ProductsContainerComponent(driver);
	}

	// Page Object

	// Functional

	// Business Logic
}
