package com.softserve.edu.opencart.tests.shoppingcart;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage.PRODUCT_ADDED_TO_CART;

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

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .gotoAppleCinemaPage(appleCinemaProduct)
                .addAppleCinemaToCartWithAllOpt(text,textarea,fileValue,date,time,datatime,qty)
                .getProductAddedToCartText();


        System.out.println(actual);

        Assert.assertTrue(actual.contains(String.format(PRODUCT_ADDED_TO_CART, "Apple Cinema \"")));

    }




}
