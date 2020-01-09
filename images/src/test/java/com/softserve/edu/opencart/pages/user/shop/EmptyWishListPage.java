package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyWishListPage  extends AccountSidebarLoggedPart {

    private WebElement continueButton;

    public EmptyWishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));

    }

    // Page Object

    // continueButton;
    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
}
