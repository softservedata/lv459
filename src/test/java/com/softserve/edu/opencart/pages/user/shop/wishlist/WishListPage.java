package com.softserve.edu.opencart.pages.user.shop.wishlist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;

/**
 *  Wish list page.<
 */
public class WishListPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    private WishListTableContainerComponent wishListTableContainerComponent; //composition

    public WishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    /**
     * This method inits all elements on page.
     */
    private void initElements() {
        // init elements
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        wishListTableContainerComponent = new WishListTableContainerComponent(driver);
    }

    // Page Object

    /**
     * This method gets continue button.
     */
    public WebElement getContinueButton() {
        return continueButton;
    }

    /**
     * This method clicks on continue button.
     */
    public void clickContinueButton() {
        getContinueButton().click();
    }

    /**
     * This method gets Wish List Table Container Component.
     */
    public WishListTableContainerComponent getWishListTableContainerComponent() {
        return wishListTableContainerComponent;
    }

    //functional

    /**
     * This method gets product name.
     */
    public  WishListPage getProductName(IProduct product) {
        wishListTableContainerComponent.getWishListTableComponentByName(product);
        return new WishListPage(driver);
    }

    /**
     * This method gets product price.
     */
    public  WishListPage getProductPrice(IProduct product){
        wishListTableContainerComponent.getWishListTableComponentPriceByName(product);
        return new WishListPage(driver);
    }

    /**
     * This method gets product module.
     */
    public  WishListPage getProductModule(IProduct product){
        wishListTableContainerComponent.getWishListTableComponentModelByName(product);
        return new WishListPage(driver);
    }

    /**
     * This method add product to shopping cart .
     */
    public WishListMessagePage addProductToShoppingCart(IProduct product) {
        wishListTableContainerComponent.clickWishListTableComponentAddToCartButtonByName(product);
        return new WishListMessagePage(driver);
    }

    /**
     * This method deletes product from wish list.
     */
    public WishListMessagePage deleteProductFromWishList(IProduct product) {
        wishListTableContainerComponent.clickWishListTableComponentRemoveButtonByName(product);
        return new WishListMessagePage(driver);
    }

    //BL

    /**
     * This method is written to go to MyAccountPage.
     */
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }

    /**
     * This method is written to go to WishListMessagePage.
     */
    public WishListMessagePage gotoWishListMessagePage(){
        return new WishListMessagePage(driver);
    }

    /**
     * This method clears wish list.
     */
    public EmptyWishListPage removeAllProductsFromWishList() {
        initElements();
        List<WebElement> closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
        System.out.println(closeButtons.size());
        while (closeButtons.size() > 0) {
            closeButtons.get(0).click();
            closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
        }
        return new EmptyWishListPage(driver);
    }
}