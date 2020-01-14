package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MenuPart {
    protected WebDriver driver;
    private WebElement incomingMessages;
    private WebElement drafts;
    private WebElement sentMessages;
    private WebElement spam;
    
    public MenuPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        drafts = driver.findElement(By.cssSelector("drafts"));
        incomingMessages = driver.findElement(By.cssSelector(".sidebar__list-link.inbox.has-unread"));
        sentMessages = driver.findElement(By.cssSelector(".sidebar__list-link.sent"));
        spam = driver.findElement(By.cssSelector(".sidebar__list-link.spam"));
    }
    //
    public WebElement getIncomingMessages() {
        return incomingMessages;
    }
    public WebElement getDrafts() {
        return drafts;
    }
    public WebElement getSentMessages() {
        return sentMessages;
    }
    public WebElement getSpam() {
        return spam;
    }
    //
    public IncomingMessagesPage clickIncomingMessages() {
        return new IncomingMessagesPage(driver);
    }
    
}
