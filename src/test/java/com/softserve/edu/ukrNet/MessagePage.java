package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagePage extends MenuPart {
    private WebElement restoreLink;

    public MessagePage(WebDriver driver) {
        super(driver);
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
