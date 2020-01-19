package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUserSuccessPage extends MenuPart {
    private WebElement alertMessage;

    public EditUserSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public String getAlertMessageText() {
        return getAlertMessage().getText();
    }
}
