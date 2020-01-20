package com.softserve.edu.opencart.tests.wishlist;

import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_REMOVED;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.tests.LocalTestRunner;

/**
 * This class verify if button remove from Wish List works.
 */
public class RemoveFromWishListTest extends LocalTestRunner {

    @DataProvider
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getBohdanaUser() },
        };
    }

    /**
     * This method check if button 'Remove from wish list' works.
     */
    @Test(dataProvider = "customers")
    public void checkRemoveFromWishList(IUser validUser) {

        //get product from repository
        IProduct macBookProduct = ProductRepository.get().getMacBook();

        //login and add to wish list
        loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToWishList(macBookProduct);

        //go to wish list and delete product
        String actual = loadApplication()
                .gotoWishListPage()
                .deleteProductFromWishList(macBookProduct)
                .getRemoveMessageText();

        //check message
        Assert.assertTrue(actual
                .contains(PRODUCT_REMOVED));
    }
}