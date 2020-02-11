package com.softserve.edu.opencart.tests.wishlist;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListPage;
import com.softserve.edu.opencart.tests.runner.LocalTestRunner;

/**
 * This class contains test which verify whether the number
 * of added elements are the same to the number of items that are displayed on
 * the page.
 */
public class NumberEqualityTest extends LocalTestRunner {

    private WishListPage wishListPage = null;
    private static String EXPECTED_NUMBER = "2";

    @DataProvider
    public Object[][] customers() {
        return new Object[][]{
                {UserRepository.get().getBohdanaUser()},
        };
    }

    /**
     * This method check if Wish List is empty by default.
     */
    @Test(dataProvider = "customers")
    public void checkAddToCartFromWishList(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        IProduct appleCinema30  = ProductRepository.get().getAppleCinema30();

        //Login and add to wish list
        loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToWishList(macBookProduct);

        //add second product
       loadApplication()
                .addProductToWishList(appleCinema30);

       //go to wish list page
        wishListPage = loadApplication().gotoWishListPage();

        //check whether 2 product were added
        Assert.assertTrue(wishListPage.getWishListText()
                .contains(EXPECTED_NUMBER));
    }

    @AfterMethod
    public void clearWishList() {
        if(wishListPage != null) {
            //clear wish list
            wishListPage.removeAllProductsFromWishList();
        }
    }
}