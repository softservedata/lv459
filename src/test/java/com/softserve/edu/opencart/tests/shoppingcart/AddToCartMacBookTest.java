package com.softserve.edu.opencart.tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.MacBookInfo;
import com.softserve.edu.opencart.data.MacBookInfoRepository;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage;
import com.softserve.edu.opencart.tests.runner.LocalTestRunner;

public class AddToCartMacBookTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getCorrectUser() },//TODO
        };
    }


    @Test(dataProvider = "customers")
    public void addToCartFromProductInfoPageTest(IUser validUser){

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        MacBookInfo macBookProductInfo = MacBookInfoRepository.getMacBookInfo();


        AlertMessagePage alertMessagePage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .gotoProductInfoMacBookPage(macBookProduct)
                .addMacBookToCartWithQty(macBookProductInfo);



        Assert.assertTrue(alertMessagePage.getProductAddedToCartText().contains(String.format(AlertMessagePage.PRODUCT_ADDED_TO_CART, "MacBook")));


        alertMessagePage
                .gotoShoppingCart()
                .deleteProductOnShoppingCart(macBookProduct);

    }



}
