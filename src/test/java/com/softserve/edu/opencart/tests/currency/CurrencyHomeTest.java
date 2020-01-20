package com.softserve.edu.opencart.tests.currency;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.tests.LocalTestRunner;

public class CurrencyHomeTest extends TestRunner {

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
                .getProductComponentPriceByName(MAC_BOOK);

        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_TAX_PRICE, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2Test(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);

        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_NO_TAX_PRICE, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTaxPriceTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);

        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_TAX_PRICE, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2Test(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_NO_TAX_PRICE, actual.substring(m.start(), m.end()));
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
                .getProductComponentPriceByName(MAC_BOOK);
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_TAX_PRICE_POUND, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookPrice2PoundTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_NO_TAX_PRICE_POUND, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyTaxData")
    public void checkMacBookNoTax2PoundPriceTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_TAX_PRICE_POUND, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "currencyNoTaxData")
    public void checkMacBookNoTaxPrice2PoundTest(IUser validUser) {

        String actual = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoHomePage()
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);
        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_NO_TAX_PRICE_POUND, actual.substring(m.start(), m.end()));
    }

}
