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

    /**
     * <h3>This method inits all elements on page.</h3>
     */
    private void initElements() {
        // init elements
        removeMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        addToCartMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
        crossButton = driver.findElement(By.xpath("//div[@class = 'alert alert-success']//button"));
    }

    //page object

    /**
     * <h3>This method gets cross button.</h3>
     */
    public WebElement getCrossButton() {
        return crossButton;
    }

    /**
     * <h3>This method clicks on cross button.</h3>
     */
    public void clickCrossButton() {
        getCrossButton().click();
    }


    //functional

    /**
     * <h3>This method gets remove message.</h3>
     */
    public WebElement getRemoveMessage() {
        return removeMessage;

    }

    /**
     * <h3>This method gets remove message text.</h3>
     */
    public String getRemoveMessageText() {
        return getRemoveMessage().getText();
    }

    /**
     * <h3>This method gets add ot cart message.</h3>
     */
    public WebElement getAddToCartMessage() {
        return addToCartMessage;
    }

    /**
     * <h3>This method gets add to cart message text.</h3>
     */
    public String getAddToCartMessageText() {
        return getAddToCartMessage().getText();
    }

    //Business Logic

    /**
     * <h3>This method clicks on cross button.</h3>
     */
    public MyAccountPage clickOnCrossButton() {
        clickCrossButton();
        return new MyAccountPage(driver);
    }
}
