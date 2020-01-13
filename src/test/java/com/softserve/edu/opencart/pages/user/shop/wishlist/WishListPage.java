package com.softserve.edu.opencart.pages.user.shop.wishlist;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;
    private WishListTableContainerComponent wishListTableContainerComponent; //composition

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

    //functional

    //get name of product
    public  WishListPage getProductName(Product product) {
        wishListTableContainerComponent.getWishListTableComponentByName(product);
        return new WishListPage(driver);  //NOT SURE HOW MADE IT RIGHT
    }

    //get price of product
    public  WishListPage getProductPrice(Product product){
        wishListTableContainerComponent.getWishListTableComponentPriceByName(product);//change names of methods , name of product
        return new WishListPage(driver);
    }

    //get model of product
    public  WishListPage getProductModule(Product product){
        wishListTableContainerComponent.getWishListTableComponentModelByName(product);//change names of methods , name of product
        return new WishListPage(driver);
    }


    //дьоргає контейнер, а контейнер дьоргає компонент!!!


    //  TODO  Business Logic

    //add product to Shopping cart
    public WishListPage addProductToShoppingCart(Product product) {
        wishListTableContainerComponent.clickWishListTableComponentAddToCartButtonByName(product); //change names of methods, name of product
        return new WishListMessagePage(driver);
    }

    //delete product from Wish List
    public WishListPage deleteProductFromWishList(Product product) {
        wishListTableContainerComponent.clickWishListTableComponentRemoveButtonByName(product); //change names of methods, name of product
        return new WishListMessagePage(driver);
    }

    //go to product page after click on name
//    public  ProductCartComponent goToProductPage(Product product) {
//        wishListTableContainerComponent.clickWishListTableComponentOnName(product); //change names of methods , name of product
//        return new ProductCartComponent(driver);
//    }

    //go to My Account Page
    public MyAccountPage goToMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
    //go to Wish List Message Page
    public WishListMessagePage gotoWishListMessagePage(){
        return new WishListMessagePage(driver);
    }
}