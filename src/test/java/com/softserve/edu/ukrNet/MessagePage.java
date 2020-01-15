package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagePage {
    private WebElement restoreLink;
    private WebDriver driver;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        restoreLink = driver.findElement(By.cssSelector(".readmsg__body a"));
    }

    public WebElement getRestorePasswordLink() {
        return restoreLink;
    }

    public void clickRestorePasswordLink() {
        getRestorePasswordLink().click();
    }

}
