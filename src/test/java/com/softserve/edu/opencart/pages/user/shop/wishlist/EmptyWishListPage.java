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

    /**
     * <h3>This method inits all elements on page.</h3>
     */
    private void initElements() {
        // init elements
        labelText = driver.findElement(By.cssSelector("h2 + p"));
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
    }

    // Page Object

    /**
     * <h3>This method gets web element labelText.</h3>
     */
    public WebElement getLabel(){
        return labelText;
    }

    /**
     * <h3>This method gets web element labelText text.</h3>
     */
    public String getLabelText() {
        return getLabel().getText();
    }

    /**
     * <h3>This method gets continueButton.</h3>
     */
    public WebElement getContinueButton() {
        return continueButton;
    }

    /**
     * <h3>This method clicks on continueButton.</h3>
     */
    public void clickContinueButton() {
        getContinueButton().click();
    }

    //BL

    /**
     * <h3>This method is written to go to  My Account Page.</h3>
     */
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}