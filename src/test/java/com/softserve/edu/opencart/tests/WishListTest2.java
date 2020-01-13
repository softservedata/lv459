package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.shop.WishListPage;

import static com.softserve.edu.opencart.pages.user.shop.WishListMessagePage.PRODUCT_REMOVED;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest2 extends LocalTestRunner {
    @Test
    public void checkRemoveFromWishList(User validUser) {

//        @DataProvider  //(parallel = true)
//        public Object[][] customers() {
//            return new Object[][] {
//                    { UserRepository.getDefault() },
//                    //{ UserRepository.getHahaha() },
//            };
//        }
        MyAccountPage myAccountPage = loadApplication().gotoLoginPage().successfulLogin(validUser);
        presentationSleep();

        Product macBookProduct = ProductRepository.getIPhone3();

        //ADD TO WISH LIST
        HomePage homePage = loadApplication().addProductToWishList(macBookProduct);

        WishListPage wishListPage = myAccountPage.gotoWishListRight();
        presentationSleep();

        //REMOVE FROM WISH LIST
        wishListPage.deleteProductFromWishList(macBookProduct);;

        WishListMessagePage wishListMessagePage = wishListPage.gotoWishListMessagePage();

        Assert.assertTrue(wishListMessagePage.getRemoveMessageText().equals(PRODUCT_REMOVED));
        presentationSleep();

    }
}