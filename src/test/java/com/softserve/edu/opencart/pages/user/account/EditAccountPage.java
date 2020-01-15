package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends AccountSidebarLoggedPart {

    private WebElement firstNameField;
    private WebElement emailField;
    private WebElement continueButton;

    public EditAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        firstNameField = driver.findElement(By.name("firstname"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        emailField = driver.findElement(By.id("input-email"));
    }

    // Page Object

    // firstNameField
    public WebElement getFirstNameField() {
        return firstNameField;
    }
    
    public WebElement getEmailField() {
        return emailField;
    }

    public String getFirstNameFieldText() {
        return getFirstNameField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }
    
    public String getEmailFieldText() {
        return getEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearFirstNameField() {
        getFirstNameField().clear();
    }

    public void clickFirstNameField() {
        getFirstNameField().click();
    }

    public void setFirstNameField(String text) {
        getFirstNameField().sendKeys(text);
    }

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public MyAccountPage gotoContinue(){
        clickContinueButton();
        return new MyAccountPage(driver);
    }

}