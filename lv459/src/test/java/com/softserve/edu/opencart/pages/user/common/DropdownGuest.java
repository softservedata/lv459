package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownGuest {

	private WebDriver driver;
	//
	private WebElement register;
	private WebElement login;

	protected DropdownGuest(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		register = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
		login = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]"));
	}

	// Page Object

	// register
	public WebElement getRegister() {
		return register;
	}

	public String getRegisterText() {
		return getRegister().getText();
	}

	public void clickRegister() {
		getRegister().click();
	}

	// login
	public WebElement getLogin() {
		return login;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public void clickLogin() {
		getLogin().click();
	}

	// Functional

	// Business Logic

}
