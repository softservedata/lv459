package com.softserve.edu.opencart.tests.shoppingcart;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage.PRODUCT_ADDED_TO_CART;

public class AddToCartFromProductInfoPageTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getCorrectUser() },//TODO
        };
    }


    @Test(dataProvider = "customers")
    public void addToCartFromProductInfoPageTest(IUser validUser){

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        ProductInfoMacBook macBookProductInfo = ProductInfoMacRepository.getMacBookInfo();

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .gotoProductInfoMacBookPage(macBookProduct)
                .addMacBookToCartWithQty(macBookProductInfo)
                .getProductAddedToCartText();


        System.out.println(actual);

        Assert.assertTrue(actual.contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

    }



}
