package com.softserve.edu.opencart.pages.admin.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.pages.admin.common.HeaderPart;
import com.softserve.edu.opencart.pages.admin.dashboard.Dashboard;

public class SigninPage extends HeaderPart {
	
	public static final String EXPECTED_PANEL_TITLE_MESSAGE = "Please enter your login details.";
	//
	private WebElement panelTitle;
	private WebElement username;
	private WebElement password;
	private WebElement loginButton;

	public SigninPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		panelTitle = driver.findElement(By.cssSelector("h1.panel-title"));
		username = driver.findElement(By.id("input-username"));
		password = driver.findElement(By.id("input-password"));
		loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
	}

	// Page Object
	
	// panelTitle
	public WebElement getPanelTitle() {
		return panelTitle;
	}

	public String getPanelTitleText() {
		return getPanelTitle().getText();
	}
	
	// username
	public WebElement getUsername() {
		return username;
	}

	public String getUsernameText() {
		return getUsername().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clearUsername() {
		getUsername().clear();
	}

	public void clickUsername() {
		getUsername().click();
	}

	public void setUsername(String email) {
		getUsername().sendKeys(email);
	}

	// password
	public WebElement getPassword() {
		return password;
	}

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

	public void clearPassword() {
		getPassword().clear();
	}

	public void clickPassword() {
		getPassword().click();
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	// loginButton
	public WebElement getLoginButton() {
		return loginButton;
	}

    public String getLoginButtonText() {
        return getLoginButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

	public void clickLoginButton() {
		getLoginButton().click();
	}

	// Functional

	private void enterUsername(String username) {
		clickUsername();
		clearUsername();
		setUsername(username);
	}

	private void enterPassword(String password) {
		clickPassword();
		clearPassword();
		setPassword(password);
	}

	public void fillLogin(IUser user) {
		enterUsername(user.getFirstName());
		enterPassword(user.getPassword());
		clickLoginButton();
	}

	// Business Logic
	
	public Dashboard successfulLogin(IUser validAdmin){
		//System.out.println("***" + validAdmin);
		fillLogin(validAdmin);
		return new Dashboard(driver);
	}

	public UnsuccessfulSigninPage unsuccessfulLoginPage(IUser invalidAdmin){
		fillLogin(invalidAdmin);
		return new UnsuccessfulSigninPage(driver);
	}

}
