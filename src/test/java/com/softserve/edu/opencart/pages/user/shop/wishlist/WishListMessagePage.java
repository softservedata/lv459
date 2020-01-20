package com.softserve.edu.opencart.pages.user.shop.wishlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.account.MyAccountPage;

public class WishListMessagePage extends WishListPage {

    public static final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
    public static final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

    private WebElement removeMessage;
    private WebElement addToCartMessage;
    private WebElement crossButton;

    public WishListMessagePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    /**
     * This method inits all elements on page.
     */
    private void initElements() {
        // init elements
        removeMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        addToCartMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        crossButton = driver.findElement(By.xpath("//div[@class = 'alert alert-success']//button"));
    }

    //page object

    /**
     * This method gets cross button.
     */
    public WebElement getCrossButton() {
        return crossButton;
    }

    /**
     * This method clicks on cross button.
     */
    public void clickCrossButton() {
        getCrossButton().click();
    }


    //functional

    /**
     * This method gets remove message.
     */
    public WebElement getRemoveMessage() {
        return removeMessage;

    }

    /**
     * This method gets remove message text.
     */
    public String getRemoveMessageText() {
        return getRemoveMessage().getText();
    }

    /**
     * This method gets add ot cart message.
     */
    public WebElement getAddToCartMessage() {
        return addToCartMessage;
    }

    /**
     * This method gets add to cart message text.
     */
    public String getAddToCartMessageText() {
        return getAddToCartMessage().getText();
    }

    //Business Logic

    /**
     * This method clicks on cross button.
     */
    public MyAccountPage clickOnCrossButton() {
        clickCrossButton();
        return new MyAccountPage(driver);
    }
}
