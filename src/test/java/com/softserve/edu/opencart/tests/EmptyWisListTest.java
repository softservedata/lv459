package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.EmptyWishListPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmptyWisListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.getBohdanaUser() },
        };
    }

    @Test
    public void checkWishList(User validUser) {

        MyAccountPage myAccountPage = loadApplication().gotoLoginPage().successfulLogin(validUser);
        presentationSleep();

        EmptyWishListPage  emptyWishListPage =  myAccountPage.gotoEmptyWishListPage();
        presentationSleep();

       Assert.assertTrue(emptyWishListPage.getLabelText().equals(EmptyWishListPage.EMPTY_WISH_LIST_MESSAGE));
        presentationSleep();
    }
}
