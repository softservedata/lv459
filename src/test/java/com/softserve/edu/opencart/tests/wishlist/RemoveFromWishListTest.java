package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static com.softserve.edu.opencart.pages.user.shop.wishlist.WishListMessagePage.PRODUCT_REMOVED;

public class RemoveFromWishListTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getHahaha() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void checkRemoveFromWishList(IUser validUser) {
        IProduct macBookProduct = ProductRepository.get().getMacBook();
        //LOGIN
        loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage().addProductToWishList(macBookProduct);

        //TODO Explicit wait
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //(new WebDriverWait(driver, 10))
        //                .until(ExpectedConditions.());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        presentationSleep();

        String actual = loadApplication()
                .gotoWishListPage()
                .deleteProductFromWishList(macBookProduct)
                .getRemoveMessageText();

        Assert.assertTrue(actual
                .contains(PRODUCT_REMOVED));

    }
}