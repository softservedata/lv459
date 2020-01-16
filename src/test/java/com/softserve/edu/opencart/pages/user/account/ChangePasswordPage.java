package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class ChangePasswordPage extends AccountSidebarGuestPart {

    private WebDriver driver;
    private WebElement confirmInputPassword;
    private WebElement inputPassword;
    private WebElement buttonConfirm;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        inputPassword = driver.findElement(By.id("input-password"));
        confirmInputPassword = driver.findElement(By.id("input-confirm"));
        buttonConfirm = driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getConfirmInputPassword() {
        return confirmInputPassword;
    }

    public WebElement getButtonConfirmd() {
        return buttonConfirm;
    }

    public void clickInputPassword() {
        getInputPassword().click();
    }

    public void clickConfirmInputPassword() {
        getConfirmInputPassword().click();
    }

    public void clickButtonConfirm() {
        getButtonConfirmd().click();
    }

    public void clearInputPassword() {
        getInputPassword().clear();
    }

    public void clearConfirmInputPassword() {
        getConfirmInputPassword().clear();
    }

    public void setPassword(String password) {
        getInputPassword().sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        getConfirmInputPassword().sendKeys(password);
    }
    
    public void fillPassword(String password) {
        clickInputPassword();
        clearInputPassword();
        setPassword(password);
    }
    
    public void fillConfirmPassword(String password) {
        clickConfirmInputPassword();
        clearConfirmInputPassword();
        setConfirmPassword(password);
    }
    
    public PasswordChangedLoginPage enterNewPassword(IUser user) {
        fillPassword(user.getPassword());
        fillConfirmPassword(user.getPassword());
        clickButtonConfirm();
        return new PasswordChangedLoginPage(driver);
    }

}