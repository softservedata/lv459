package com.softserve.edu.opencart.tests.shoppingcart;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage.PRODUCT_ADDED_TO_CART;

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

        AlertMessagePage alertMessagePage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToShoppingCart(macBookProduct);

        Assert.assertTrue(alertMessagePage.getProductAddedToCartText().contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

        alertMessagePage
                .gotoShoppingCart()
                .deleteProductOnShoppingCart(macBookProduct);
    }
}
