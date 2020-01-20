package com.softserve.edu.opencart.tests.currency;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.ICurrency;

public class CurrencyAdminTest extends AdminTestRunner {
    @DataProvider
    private Object[][] loginAdminData() {
        return new Object[][]{
                {AdminRepo.get().validAdmin(), CurrencyRepository.get().getNewUACurrency()}
        };
    }

    @DataProvider
    private Object[][] currencyAdminData() {
        return new Object[][]{
                {CurrencyRepository.get().getNewUACurrency()}
        };
    }

    @Test(dataProvider = "loginAdminData")
    public void checkMacBookPriceTest(IAdmin validAdmin, ICurrency currency) {
         List<String> actual = loadAdminPage()
                .successfulLogin(validAdmin)
                .gotoCurrencyPage()
                .gotoAddNewCurrecyPage()
                .addNewCurrency(currency)
                 .getCurrenciesContainerComponent()
                 .getCurrencyComponentTitles();

        System.out.println(actual);
        //Assert.assertTrue(actual.contains(HRYVNIA));
    }
}
