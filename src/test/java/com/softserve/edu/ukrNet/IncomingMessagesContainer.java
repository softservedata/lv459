package com.softserve.edu.ukrNet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncomingMessagesContainer {

    private final String MESSAGE_COMPONENT_CSS_SELECTOR = "tbody > tr";

    protected WebDriver driver;
    private List<IncomingMessageComponent> incomingMessageComponents;

    public IncomingMessagesContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        incomingMessageComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(MESSAGE_COMPONENT_CSS_SELECTOR))) {
            incomingMessageComponents.add(new IncomingMessageComponent(current, driver));
        }
    }

    public List<IncomingMessageComponent> getIncomingMessageComponents() {
        return incomingMessageComponents;
    }

    public int getincomingMessageComponentsSize() {
        return getIncomingMessageComponents().size();
    }
}
