package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordChangedLoginPage extends LoginPage{
    
    private WebDriver driver;
    private WebElement alertMessage;

    public PasswordChangedLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
        alertMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
    }
    
    public WebElement getAlertMessage() {
        return alertMessage;
    }
    
    public String getAlertMessageText() {
      return  getAlertMessage().getText();
    }

}
