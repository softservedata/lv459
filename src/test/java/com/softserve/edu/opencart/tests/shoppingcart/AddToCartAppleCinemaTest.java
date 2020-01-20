package com.softserve.edu.opencart.tests.shoppingcart;

import static com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage.PRODUCT_ADDED_TO_CART;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AppleCinemaInfo;
import com.softserve.edu.opencart.data.AppleCinemaInfoRepository;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;

public class AddToCartAppleCinemaTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getCorrectUser() },//TODO
        };
    }

    @Test(dataProvider = "customers")
    public void addToCartAppleCinemaPositiveTest(IUser validUser){

        IProduct appleCinemaProduct = ProductRepository.get().getAppleCinema30();
        AppleCinemaInfo text = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo textarea = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo fileValue = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo date = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo time = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo datatime = AppleCinemaInfoRepository.getAppleCinemaInfo();
        AppleCinemaInfo qty = AppleCinemaInfoRepository.getAppleCinemaInfo();

        AlertMessagePage alertMessagePage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .gotoAppleCinemaPage(appleCinemaProduct)
                .addAppleCinemaToCartWithAllOpt(text,textarea, fileValue, date,time,datatime,qty);

        Assert.assertTrue(alertMessagePage.getProductAddedToCartText().contains(String.format(PRODUCT_ADDED_TO_CART, "Apple Cinema 30\"")));

        alertMessagePage
                .gotoShoppingCart()
                .removeAllProductsFromCartPage();
    }




}
