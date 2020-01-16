package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.EmptyWishListPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * <h3> This class contains verify if  Wish List is empty by default.</h3>
 */
public class EmptyWisListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getBohdanaUser() },
        };
    }

    /**
     * <h3>This method check if Wish List is empty by default.</h3>
     */
    @Test(dataProvider = "customers")
    public void checkWishListIsEmpty(IUser validUser) {

        //login
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        //go to empty wish list page
        EmptyWishListPage  actualResult =  myAccountPage.gotoEmptyWishListPage();

        //check whether it contains message
        Assert.assertTrue(actualResult
               .getLabelText()
               .equals(EmptyWishListPage.EMPTY_WISH_LIST_MESSAGE));
    }
}
