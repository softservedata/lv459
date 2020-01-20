package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_ADDED_TO_CART;

/**
 * This class verify if button add to cart in Wish List work.
 */
public class AddToCartFromWishListTest extends LocalTestRunner {

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
        WishListMessagePage wishListMessagePage = loadApplication()
                .gotoWishListPage()
                .addProductToShoppingCart(macBookProduct);

        //check message
        Assert.assertTrue(wishListMessagePage.getAddToCartMessageText()
                .contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));

        //clear wish list after test
        wishListMessagePage.removeAllProductsFromWishList();

    }
}

