package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;

public class WishListTest1 extends LocalTestRunner {

            @DataProvider  //(parallel = true)
            public Object[][] customers() {
            return new Object[][] {
                    { UserRepository.getBohdanaUser() },
            };
        }

        @Test(dataProvider = "customers")
        public void checkWishList(User validUser) {

        MyAccountPage myAccountPage = loadApplication().gotoLoginPage().successfulLogin(validUser);
        presentationSleep();


        Product macBookProduct = ProductRepository.getMacBook();

        //ADD TO WISH LIST
        //TODO
        HomePage homePage = loadApplication().addProductToWishList(macBookProduct);

        WishListPage wishListPage = homePage.gotoWishListPage();
        presentationSleep();

       // Check if product was added
        Assert.assertTrue(wishListPage.getProductName(macBookProduct).equals("iPhone"));
        presentationSleep();

    }
}
