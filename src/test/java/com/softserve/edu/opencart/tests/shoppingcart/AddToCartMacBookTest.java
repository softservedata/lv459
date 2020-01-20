package com.softserve.edu.opencart.tests.shoppingcart;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.MacBookInfo;
import com.softserve.edu.opencart.data.MacBookInfoRepository;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.CartEmptyPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;

public class AddToCartMacBookTest extends LocalTestRunner {

    @DataProvider  //(parallel = true)
    public Object[][] customers() {
        return new Object[][] {
                { UserRepository.get().getCorrectUser() },//TODO
        };
    }


    @Test(dataProvider = "customers")
    public void addToCartFromProductInfoPageTest(IUser validUser){

        IProduct macBookProduct = ProductRepository.get().getMacBook();
        MacBookInfo macBookProductInfo = MacBookInfoRepository.getMacBookInfo();

        CartEmptyPage cartEmptyPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .gotoProductInfoMacBookPage(macBookProduct)
                .addMacBookToCartWithQty(macBookProductInfo)
                .gotoShoppingCart()
                .removeAllProductsFromCartPage();


        //Assert.assertTrue(alertMessagePage.getProductAddedToCartText().contains(String.format(PRODUCT_ADDED_TO_CART, "MacBook")));



    }



}
