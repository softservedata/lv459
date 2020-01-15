package com.softserve.edu.opencart.pages.user.shop.wishlist;

import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private void initElements() {
        // init elements
        removeMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        addToCartMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        crossButton = driver.findElement(By.xpath("//div[@class = 'alert alert-success']//button"));
    }

    //page object

    public WebElement getCrossButton() {
        return crossButton;
    }

    public void clickCrossButton() {
        getCrossButton().click();
    }


    //functional

    // removeMessage
    public WebElement getRemoveMessage() {
        return removeMessage;

    }

    public String getRemoveMessageText() {
        return getRemoveMessage().getText();
    }


    // addToCartMessage
    public WebElement getAddToCartMessage() {
        return addToCartMessage;

    }

    public String getAddToCartMessageText() {
        return getAddToCartMessage().getText();
    }

    //Business Logic

    //click on cross button
    public MyAccountPage clickOnCrossButton() {
        clickCrossButton();
        return new MyAccountPage(driver);
    }
}
