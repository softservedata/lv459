package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.shop.wishlist.EmptyWishListPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmptyWisListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getHahaha() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkWishListIsEmpty(IUser validUser) {

        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        EmptyWishListPage  actualResult =  myAccountPage.gotoEmptyWishListPage();

        Assert.assertTrue(actualResult
               .getLabelText()
               .equals(EmptyWishListPage.EMPTY_WISH_LIST_MESSAGE));
    }
}
