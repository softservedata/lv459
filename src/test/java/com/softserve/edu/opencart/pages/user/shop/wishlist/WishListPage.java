package com.softserve.edu.opencart.pages.user.shop.wishlist;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * <h3> </h3>
 *
 */
public class WishListPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    private WishListTableContainerComponent wishListTableContainerComponent; //composition

    public WishListPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    /**
     * <h3>This method inits all elements on page.</h3>
     */
    private void initElements() {
        // init elements
        continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        wishListTableContainerComponent = new WishListTableContainerComponent(driver);
    }

    // Page Object

    /**
     * <h3>This method gets continue button.</h3>
     */
    public WebElement getContinueButton() {
        return continueButton;
    }

    /**
     * <h3>This method clicks on continue button.</h3>
     */
    public void clickContinueButton() {
        getContinueButton().click();
    }

    /**
     * <h3>This method gets Wish List Table Container Component.</h3>
     */
    public WishListTableContainerComponent getWishListTableContainerComponent() {
        return wishListTableContainerComponent;
    }

    //functional

    /**
     * <h3>This method gets product name.</h3>
     */
    public  WishListPage getProductName(IProduct product) {
        wishListTableContainerComponent.getWishListTableComponentByName(product);
        return new WishListPage(driver);
    }

    /**
     * <h3>This method gets product price.</h3>
     */
    public  WishListPage getProductPrice(IProduct product){
        wishListTableContainerComponent.getWishListTableComponentPriceByName(product);//change names of methods , name of product
        return new WishListPage(driver);
    }

    /**
     * <h3>This method gets product module.</h3>
     */
    public  WishListPage getProductModule(IProduct product){
        wishListTableContainerComponent.getWishListTableComponentModelByName(product);//change names of methods , name of product
        return new WishListPage(driver);
    }

    /**
     * <h3>This method add product to shopping cart .</h3>
     */
    public WishListMessagePage addProductToShoppingCart(IProduct product) {
        wishListTableContainerComponent.clickWishListTableComponentAddToCartButtonByName(product); //change names of methods, name of product
        return new WishListMessagePage(driver);
    }

    /**
     * <h3>This method deletes product from wish list.</h3>
     */
    public WishListMessagePage deleteProductFromWishList(IProduct product) {
        wishListTableContainerComponent.clickWishListTableComponentRemoveButtonByName(product); //change names of methods, name of product
        return new WishListMessagePage(driver);
    }

//    go to product page after click on name
//    public ProductInfo goToProductPage(IProduct product) {
//        wishListTableContainerComponent.clickWishListTableComponentOnName(product); //change names of methods , name of product
//        return new ProductInfo(driver);
//    }

    /**
     * <h3>This method is written to go to MyAccountPage.</h3>
     */
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }

    /**
     * <h3>This method is written to go to WishListMessagePage.</h3>
     */
    public WishListMessagePage gotoWishListMessagePage(){
        return new WishListMessagePage(driver);
    }

    /**
     * <h3>This method clears wish list.</h3>
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