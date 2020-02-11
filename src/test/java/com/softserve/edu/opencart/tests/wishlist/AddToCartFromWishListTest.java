package com.softserve.edu.opencart.tests.wishlist;

import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_ADDED_TO_CART;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.tests.runner.LocalTestRunner;

/**
 * This class verify if button add to cart in Wish List works.
 */
public class AddToCartFromWishListTest extends LocalTestRunner {

    private  WishListMessagePage wishListMessagePage = null;

    @DataProvider
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getBohdanaUser() },
        };
    }

    /**
     * This method check if button 'Add to shopping cart' works.
     */
    @Test(dataProvider = "customers")
    public void checkAddToCartFromWishList(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();

        //login and add to wish list
        loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToWishList(macBookProduct);

        //add to shopping cart
             wishListMessagePage = loadApplication()
                .gotoWishListPage()
                .addProductToShoppingCart(macBookProduct);

        //check message
        Assert.assertTrue(wishListMessagePage.getAddToCartMessageText()
                .contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

    }

    @AfterMethod public void clearWishList() {
        if( wishListMessagePage != null) {
            //clear wish list after test
            wishListMessagePage.removeAllProductsFromWishList();
        }
    }
}

