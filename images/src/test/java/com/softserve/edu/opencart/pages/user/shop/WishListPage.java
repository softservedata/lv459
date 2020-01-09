package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    private WishListTableContainerComponent wishListTableContainerComponent; //aggregation

    public WishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        wishListTableContainerComponent = new WishListTableContainerComponent(driver);
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
    public WishListTableContainerComponent getWishListTableContainerComponent() {
        return wishListTableContainerComponent;
    }


    // Functional

    //  TODO  Business Logic

    public WishListPage addProductToShoppingCart(Product product) {
       // clickAddToCartButton(product);
        return new WishListPage(driver);
    }

    public WishListPage removeProductFromWishList(Product product) {
        //clickRemoveFromWishListButton(product);
        return new WishListPage(driver);
    }

    public MyAccountPage goToMyAccountPage() {
        //clickContinueButton();
        return new MyAccountPage(driver);
    }
}