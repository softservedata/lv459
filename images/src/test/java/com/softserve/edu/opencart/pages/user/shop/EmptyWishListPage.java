package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyWishListPage  extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    // Your wish list is empty. вичитати у вигляді константи
    public static final String EMPTY_WISH_LIST_MESSAGE = "Your wish list is empty."; //очікуваний рез
    //label
    public EmptyWishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        //label = сам елемент
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
    }

    // Page Object

    //functional

    // continueButton;
    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }


    //BL
    //continue
}
