package com.softserve.edu.ukrNet;

import org.openqa.selenium.WebDriver;

public class IncomingMessagesPage extends MenuPart {
    private IncomingMessagesContainer incomingMessagesContainer;

    public IncomingMessagesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        incomingMessagesContainer = new IncomingMessagesContainer(driver);
    }

    public IncomingMessagesContainer getIncomingMessagesContainer() {
        return incomingMessagesContainer;
    }
}
