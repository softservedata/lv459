package com.softserve.edu.opencart.pages.admin.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class Dashboard extends LeftMenuPart {

	private WebElement title;

	public Dashboard(WebDriver driver) {
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
