package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListPage;
import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_REMOVED;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveFromWishListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getHahaha() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkRemoveFromWishList(IUser validUser) {
        //LOGIN
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);
        presentationSleep();

        Product macBookProduct = ProductRepository.getIPhone3();

        //ADD TO WISH LIST
        HomePage homePage = loadApplication()
                .addProductToWishList(macBookProduct);

        WishListPage wishListPage = homePage.gotoWishListPage();
        presentationSleep();

        //REMOVE FROM WISH LIST
        wishListPage.deleteProductFromWishList(macBookProduct);;

        WishListMessagePage wishListMessagePage = wishListPage.gotoWishListMessagePage();

        Assert.assertTrue(wishListMessagePage
                .getRemoveMessageText()
                .equals(PRODUCT_REMOVED));
        presentationSleep();

    }
}