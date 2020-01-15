package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WishListTest1 extends LocalTestRunner {

            @DataProvider  //(parallel = true)
            public Object[][] customers() {
            return new Object[][] {
                    { UserRepository.get().getHahaha() },//TODO
            };
        }

        @Test(dataProvider = "customers")
        public void checkWishList(IUser validUser) {

                IProduct macBookProduct = ProductRepository.get().getMacBook();

                loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                 .addProductToWishList(macBookProduct)
                 .gotoWishListPage();
        presentationSleep();

       // Check if product was added
//        Assert.assertTrue(wishListPage
//                .getProductName(macBookProduct)
//                .equals("MacBook"));
//        presentationSleep();

    }
}
