package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberEqualityTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][]{
                {UserRepository.get().getHahaha()},//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkAddToCartFromWishList(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        IProduct appleCinema30  = ProductRepository.get().getAppleCinema30();

        //LOGIN
        loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToWishList(macBookProduct);

        //TODO explicit wait
        presentationSleep();

       loadApplication()
                .addProductToWishList(appleCinema30);

        WishListPage wishListPage = loadApplication().gotoWishListPage();

        System.out.println(wishListPage.getWishListText());

        Assert.assertTrue(wishListPage.getWishListText()
                .contains("2"));

        wishListPage.removeAllProductsFromWishList();
    }
}