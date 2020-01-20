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

/**
 * This class contains test which verify whether the number
 * of added elements are the same to the number of items that are displayed on
 * the page.
 */
public class NumberEqualityTest extends LocalTestRunner {

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
        WishListPage wishListPage = loadApplication().gotoWishListPage();

        //check whether 2 product were added
        Assert.assertTrue(wishListPage.getWishListText()
                .contains(EXPECTED_NUMBER));

        //clear wish list
        wishListPage.removeAllProductsFromWishList();
    }
}