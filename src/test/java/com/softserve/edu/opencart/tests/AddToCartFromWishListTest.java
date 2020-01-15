package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListPage;
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

        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);
        presentationSleep();

        IProduct macBookProduct = ProductRepository.get().getIPhone3();


//        Assert.assertTrue(wishListMessagePage
//                .getAddToCartMessageText()
//                .equals(PRODUCT_ADDED_TO_CART));
//        presentationSleep();

    }
}

