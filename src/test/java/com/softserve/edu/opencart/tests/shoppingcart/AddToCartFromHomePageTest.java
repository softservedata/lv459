package com.softserve.edu.opencart.tests.shoppingcart;

import static com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage.PRODUCT_ADDED_TO_CART;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.AlertMessageCommon;
import com.softserve.edu.opencart.tests.runner.LocalTestRunner;

public class AddToCartFromHomePageTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getCorrectUser() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkAddToCartFromHomePage(IUser validUser){

        IProduct macBookProduct = ProductRepository.get().getMacBook();

        AlertMessageCommon alertMessageCommon = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToShoppingCart(macBookProduct);

        Assert.assertTrue(alertMessageCommon.getProductAddedToCartText().contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

        alertMessageCommon
                .gotoShoppingCart()
                .deleteProductOnShoppingCart(macBookProduct);
    }
}
