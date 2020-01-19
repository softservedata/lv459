package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.pages.user.common.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchRequestURITooLongPage extends TopPart {
    public static final String REQUEST_URI_TOO_LONG_MESSAGE = "Request-URI Too Long";
    //
    private WebElement requestToLongMessage;

    public SearchRequestURITooLongPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        requestToLongMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Request-URI Too Long')]"));
    }

    // Page Object

    // noProductMessage
    public WebElement getRequestToLongMessage() {
        return requestToLongMessage;
    }

    public String getRequestToLongMessageText() {
        return getRequestToLongMessage().getText();
    }

    // Functional

    // Business Logic
}
