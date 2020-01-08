package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.WishListTableContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    private WishListTableContainerComponent wishListContainerTableComponent;


    //private Products

    public WishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        continueButton = driver.findElement(By.));
        wishListContainerTableComponent = new WishListTableContainerComponent(driver);
    }

    // Page Object


    // continueButton;
    public WebElement getContinueButton() {
        return continueButton;
    }
    public void clickContinueButton() {
        getContinueButton().click();
    }


    // productComponentsContainer
    public WishListTableContainerComponent getProductComponentsContainer() {
        return wishListContainerTableComponent;
    }


    // Functional

    // Business Logic

    public WishListPage addProductToCart(Product product)
    {
        clickAddToCartButton(product);
        return new WishListPage(driver);
    }

    public WishListPage removeProductFromWishList(Product product)
    {
        clickAddToCartButton(product);
        return new WishListPage(driver);
    }

    public MyAccountPage clickContinue (Product product)
    {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}