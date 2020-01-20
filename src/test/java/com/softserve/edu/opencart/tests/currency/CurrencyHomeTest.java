package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyHomeTest extends LocalTestRunner {

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

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE));
/*        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.reset();
        while (m.find()) {
            Assert.assertEquals(MAC_BOOK_TAX_PRICE, actual.substring(m.start(), m.end()));
        }*/
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2Test(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTaxPriceTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2Test(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE));
    }

    //Tests with changing currency

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookPricePoundTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_TAX_PRICE_POUND));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2PoundTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTax2PoundPriceTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2PoundTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName("MacBook");

        Assert.assertTrue(actual.contains(MAC_BOOK_NO_TAX_PRICE_POUND));
    }

    //Cart tests

    //@Test(dataProvider = "currencyTaxData")
    public void checkMacBookPriceCartTest(IUser validUser) {

        IProduct macBookProduct = ProductRepository.get().getMacBook();

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
    }

}
