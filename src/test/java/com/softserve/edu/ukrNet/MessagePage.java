package com.softserve.edu.ukrNet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.account.ChangePasswordPage;

public class MessagePage {
    private WebElement restoreLink;
    private WebDriver driver;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        restoreLink = driver.findElement(By.cssSelector(".readmsg__body a"));
    }

    public WebElement getRestorePasswordLink() {
        return restoreLink;
    }

    public ChangePasswordPage clickRestorePasswordLink() {
        getRestorePasswordLink().click();
        switchTabByPartialName("reset your");
        return new ChangePasswordPage(driver);
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
