package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class ForgotPasswordPage extends AccountSidebarGuestPart {

    private WebDriver driver;
    private WebElement inputEmail;
    private WebElement buttonSubmit;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        inputEmail = driver.findElement(By.id("input-email"));
        buttonSubmit = driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    // Page Object
    public WebElement getInputEmail() {
        return inputEmail;
    }
    
    public WebElement getButtonSubmit() {
        return buttonSubmit;
    }
    
    public void clickInputEmail() {
        getInputEmail().click();
    }
    
    public void clickButtonSubmit() {
        getButtonSubmit().click();
    }
    
    public void clearInputEmail() {
        getInputEmail().clear();
    }
    
    public void setEmail(String email) {
        getInputEmail().sendKeys(email);
    }
    
    public void enterEmail(IUser correctUser) {
        clickInputEmail();
        clearInputEmail();
        setEmail(correctUser.getEmail());
        clickButtonSubmit();
    }
    // Functional

    // Business Logic

}