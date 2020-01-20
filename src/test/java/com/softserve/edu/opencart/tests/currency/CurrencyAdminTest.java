package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.data.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class CurrencyAdminTest extends AdminTestRunner {
    @DataProvider
    private Object[][] loginAdminData() {
        return new Object[][]{
                {AdminRepo.get().validAdmin(), CurrencyRepository.get().getUACurrency()}
        };
    }

    @DataProvider
    private Object[][] currencyAdminData() {
        return new Object[][]{
                {CurrencyRepository.get().getUACurrency()}
        };
    }

    @Test(dataProvider = "loginAdminData")
    public void checkMacBookPriceTest(IAdmin validAdmin, ICurrency currency) {
         /*String actual = */loadAdminPage()
                .successfulLogin(validAdmin)
                .gotoCurrencyPage()
                //.gotoAddNewCurrecyPage()
                //.addNewCurrency(currency)
                .getCurrenciesContainerComponent()
                .getCurrencyTitleText(currency);

        System.out.println();
        //Assert.assertTrue(actual.contains(HRYVNIA));
    }
}
