package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.data.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CurrencyAdminTest extends AdminTestRunner {


    @DataProvider
    private Object[][] loginAdminData() {
        return new Object[][]{
                {AdminRepo.get().validAdmin(), CurrencyRepository.get().UACurrency()}
        };
    }

    @DataProvider
    private Object[][] currencyAdminData() {
        return new Object[][]{
                {CurrencyRepository.get().UACurrency()}
        };
    }

    @Test(dataProvider = "loginAdminData", priority = 1)
    public void checkPresenceOfCreatedCurrencyTest(IAdmin validAdmin, ICurrency currency) {
        String actual = loadAdminPage()
                .successfulLogin(validAdmin)
                .gotoCurrencyPage()
                .gotoAddNewCurrecyPage()
                .addNewCurrency(currency)
                .getCurrenciesContainerComponent()
                .getCurrencyTitleText(currency);
        Assert.assertTrue(actual.contains(HRYVNIA));
    }

    @Test(dataProvider = "currencyAdminData", dependsOnMethods = "checkPresenceOfCreatedCurrencyTest")
    public void checkPresenceOfCreatedCurrencyCustomerPageTest(ICurrency currency) {
        String actual = loadMainPage()
                .chooseCurrency(Currencies.UA_HRYVNIA)
                .getProductComponentsContainer()
                .getProductComponentPriceByName(MAC_BOOK);

        Pattern p = Pattern.compile(CURRENCY_PATTERN);
        Matcher m = p.matcher(actual);
        m.find();
        Assert.assertEquals(MAC_BOOK_TAX_PRICE, actual.substring(m.start(), m.end()));
    }

    @Test(dataProvider = "loginAdminData", dependsOnMethods = "checkPresenceOfCreatedCurrencyCustomerPageTest",
            expectedExceptions = RuntimeException.class)
    public void checkRemovalOfTheCurrencyTest(IAdmin validAdmin, ICurrency currency) {
        loadAdminPage()
                .successfulLogin(validAdmin)
                .gotoCurrencyPage()
                .deleteCurrencyByName(currency)
                .getCurrenciesContainerComponent()
                .getCurrencyTitleText(currency);
    }

}
