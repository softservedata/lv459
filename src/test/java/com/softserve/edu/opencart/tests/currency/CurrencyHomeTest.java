package com.softserve.edu.opencart.tests.currency;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.softserve.edu.opencart.tests.runner.LocalAdminSingleThreadRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

//public class CurrencyHomeTest extends LocalTestRunner {
public class CurrencyHomeTest extends LocalAdminSingleThreadRunner {

    final String CURRENCY_PATTERN = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
    final String MAC_BOOK_TAX_PRICE = "602.00";
    final String MAC_BOOK_NO_TAX_PRICE = "500.00";
    final String MAC_BOOK_TAX_PRICE_POUND = "368.73";
    final String MAC_BOOK_NO_TAX_PRICE_POUND = "306.25";


    @DataProvider
    private Object[][] currencyTaxData() {
        return new Object[][]{
                {UserRepository.get().getYuriiUkUser()}
        };
    }

    @DataProvider
    private Object[][] currencyNoTaxData() {
        return new Object[][]{
                {UserRepository.get().getYuriiUaUser()}
        };
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookPriceTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE));
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        System.out.println("***********" + actual);
        Matcher m = p.matcher(actual);
/*        m.reset();*/
        /*while (m.find()) {*/
            m.find();
            Assert.assertEquals(MAC_BOOK_TAX_PRICE, actual.substring(m.start(), m.end()));
        //}
        loadMainPage().logout();
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2Test(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
        loadMainPage().logout();
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTaxPriceTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
        loadMainPage().logout();
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2Test(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
        loadMainPage().logout();
    }

    //Tests with changing currency

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookPricePoundTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE_POUND));
        loadMainPage().logout();
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2PoundTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
        loadMainPage().logout();

    }


    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTax2PoundPriceTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
        loadMainPage().logout();

    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2PoundTest(IUser validUser) {

        String actual = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
        loadMainPage().logout();
    }

    //Cart tests

    //@Test(dataProvider = "currencyTaxData")
/*    public void checkMacBookPriceCartTest(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .addProductToShoppingCart(macBookProduct)//WAIT
                .gotoShoppingCart()
                .getTotalTaxComponent()
                .getTotalText();

        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE));

        loadApplication()
                .gotoShoppingCart()
                .deleteProductOnShoppingCart(macBookProduct);
    }*/
//        String actual = loadApplication()
//                .gotoLoginPage()
//                .successfulLogin(validUser)
//                .gotoHomePage()
//                .addProductToShoppingCart(macBookProduct)//WAIT
//                .gotoShoppingCart()
//                .getTotalTaxComponent()
//                .getTotalText();
//
//        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE));
//
//        loadApplication()
//                .gotoShoppingCart()
//                .deleteProductOnShoppingCart(macBookProduct);
    //}

}
