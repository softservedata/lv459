package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * MyAccoutAmendedPage differs only by one field from MyAccountPage -
 * AlertSuccess message. On MyAccountPage it is missing, so it tooks more
 * time to finish location.
 */
public class MyAccountAmendedPage extends MyAccountPage {

    private WebElement alertSuccess;

    public MyAccountAmendedPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        if (driver.findElements(
                By.cssSelector("div.alert.alert-success")).size() > 0) {
            alertSuccess = driver.findElement(
                    By.cssSelector("div.alert.alert-success"));
        }
    }

    public String getAlerstSuccessText() {
        return alertSuccess.getText();
    }

    public WebElement getAlerstSeccess() {
        return alertSuccess;
    }
}
