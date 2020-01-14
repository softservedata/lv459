package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class IncomingMessageComponent {
    private WebElement messageLayout;
    private WebElement messageSubject;
    private WebDriver driver;

    public IncomingMessageComponent(WebElement layout, WebDriver driver) {
        this.messageLayout = layout;
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        messageSubject = messageLayout.findElement(By.cssSelector("tbody > tr .msglist__row-subject a"));
    }

    public WebElement getMessageLayout() {
        return messageLayout;
    }

    public String getMessageSubject() {
        return messageSubject.getText();
    }

    public MessagePage clickMessage() {
        getMessageLayout().click();
        return new MessagePage(driver);
    }

}
