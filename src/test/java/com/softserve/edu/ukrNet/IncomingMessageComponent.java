package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class IncomingMessageComponent {
    private WebDriver driver;
    private WebElement messageLayout;
    private WebElement messageSubject;

    public IncomingMessageComponent(WebElement layout, WebDriver driver) {
        this.messageLayout = layout;
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        messageSubject = messageLayout.findElement(By.xpath("//td[@class = 'msglist__row-subject']"));
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
