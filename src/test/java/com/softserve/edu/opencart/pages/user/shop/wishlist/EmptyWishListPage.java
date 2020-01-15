package com.softserve.edu.opencart.pages.user.shop.wishlist;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyWishListPage  extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    public static final String EMPTY_WISH_LIST_MESSAGE = "Your wish list is empty.";
    private WebElement labelText;

    public EmptyWishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        labelText = driver.findElement(By.cssSelector("h2 + p"));
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
    }

    // Page Object

    public WebElement getLabelText() {
        return labelText;
    }

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }


    //BL

    //go to My Account Page
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}