package com.softserve.edu.opencart.pages.user.shop.wishlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;

public class EmptyWishListPage  extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    public static final String EMPTY_WISH_LIST_MESSAGE = "Your wish list is empty.";
    private WebElement labelText;

    public EmptyWishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    /**
     * This method inits all elements on page.
     */
    private void initElements() {
        // init elements
        labelText = driver.findElement(By.cssSelector("h2 + p"));
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
    }

    // Page Object

    /**
     * This method gets web element labelText.
     */
    public WebElement getLabel(){
        return labelText;
    }

    /**
     * This method gets web element labelText text.
     */
    public String getLabelText() {
        return getLabel().getText();
    }

    /**
     * This method gets continueButton.
     */
    public WebElement getContinueButton() {
        return continueButton;
    }

    /**
     * This method clicks on continueButton.
     */
    public void clickContinueButton() {
        getContinueButton().click();
    }

    //BL

    /**
     * This method is written to go to  My Account Page.
     */
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}