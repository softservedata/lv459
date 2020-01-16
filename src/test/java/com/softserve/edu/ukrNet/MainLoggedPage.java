package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.EmailStatus;

public class MainLoggedPage {

    private WebElement incomingMessages;
    private WebDriver driver;

    public MainLoggedPage(WebDriver driver) {
        this.driver = driver;
        initElements();
        EmailStatus.get().setLogged(true);
    }

    private void initElements() {
        incomingMessages = driver.findElement(By.className("service__entry"));
    }

    public WebElement getIncomingMessages() {
        return incomingMessages;
    }

    public IncomingMessagesPage goToIncomingMwssages() {
        getIncomingMessages().click();

        switchTabByPartialName("вхідні");
        return new IncomingMessagesPage(driver);
    }

    /**
     * Switch to tab if tab title contains @param tabName.
     */
    private void switchTabByPartialName(String tabName) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().toLowerCase().contains(tabName.toLowerCase())) {
                break;
            }
        }
    }
}
