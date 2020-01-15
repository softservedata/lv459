package com.softserve.edu.ukrNet;

import org.openqa.selenium.WebDriver;

public class IncomingMessagesPage{
    WebDriver driver;
    private IncomingMessagesContainer incomingMessagesContainer;

    public IncomingMessagesPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        incomingMessagesContainer = new IncomingMessagesContainer(driver);
    }

    public IncomingMessagesContainer getIncomingMessagesContainer() {
        return incomingMessagesContainer;
    }


    public MessagePage goToRestorePasswordMessage(String message) {
        for (IncomingMessageComponent singleMessage : getIncomingMessagesContainer().getIncomingMessageComponents()) {
            if (singleMessage.getMessageSubject().toLowerCase().contains(message.toLowerCase())) {
                  singleMessage.clickMessage();
                  break;
            }
        }
        return new MessagePage(driver);
    }
}
