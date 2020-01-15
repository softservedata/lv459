package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_ADDED_TO_CART;

public class AddToCartFromWishListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getHahaha() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkAddToCartFromWishList(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        //LOGIN

                loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToWishList(macBookProduct);

        //TODO Explicit wait
        presentationSleep();

        //add to shopping cart
        WishListMessagePage wishListMessagePage = loadApplication()
                .gotoWishListPage()
                .addProductToShoppingCart(macBookProduct);
        //check message
        Assert.assertTrue(wishListMessagePage.getAddToCartMessageText()
                .contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

        //clear wish list after test
        wishListMessagePage.removeAllProductsFromWishList();



    }
}

