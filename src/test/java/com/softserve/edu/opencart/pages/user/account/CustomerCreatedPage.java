package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page of successfully created customer
 */
public class CustomerCreatedPage extends AccountSidebarLoggedPart {

    WebElement messageCreated;

    public CustomerCreatedPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        messageCreated = driver.findElement(By.xpath(
                "//h1[contains(text(), 'Created!')]"));


    }

    public String getMessageCreatedText() {

        if (messageCreated != null) {
            return messageCreated.getText();
        } return "User is not created!";
    }



}
