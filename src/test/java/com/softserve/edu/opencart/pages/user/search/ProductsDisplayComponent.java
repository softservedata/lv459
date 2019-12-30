package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;

public class ProductsDisplayComponent extends ProductsContainerComponent {

	private WebElement listViewButton;
	private WebElement gridViewButton;
	// TODO productCompare
	private Select inputSort;
	private Select inputLimit;

	public ProductsDisplayComponent(WebDriver driver) {
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
