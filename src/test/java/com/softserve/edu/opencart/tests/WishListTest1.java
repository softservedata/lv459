package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.WishListPage;
import org.junit.Assert;
import org.junit.Test;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;

public class WishListTest1 extends EpizyUserTestRunner {
    @Test
    public void checkWishList(User validUser) {

//        @DataProvider  //(parallel = true)
//        public Object[][] customers() {
//            return new Object[][] {
//                    { UserRepository.getDefault() },
//                    //{ UserRepository.getHahaha() },
//            };
//        }

        MyAccountPage myAccountPage = loadApplication().gotoLoginPage().successfulLogin(validUser);
        presentationSleep();

        Product macBookProduct = ProductRepository.getMacBook();

        //ADD TO WISH LIST
        HomePage homePage = loadApplication().addProductToWishList(macBookProduct);

        WishListPage wishListPage = myAccountPage.gotoWishListRight();
        presentationSleep();

       // Check if product was added
        Assert.assertTrue(wishListPage.getProductName(macBookProduct).equals("iPhone"));
        presentationSleep();
    }
}
