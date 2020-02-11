package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.tests.runner.LocalAdminSingleThreadRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.ICurrency;



//public class CurrencyAdminTest extends AdminTestRunner {
public class CurrencyAdminTest extends LocalAdminSingleThreadRunner {
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
         String actual = loadAdminPage()
                .successfulLogin(validAdmin)
                .gotoCurrencyPage()
                //.gotoAddNewCurrecyPage()
                //.addNewCurrency(currency)
                .getCurrenciesContainerComponent()
                 .getCurrencyTitleText(currency);
                //.getCurrencyTitleText(currency);

        System.out.println("***********" + actual);
        //Assert.assertTrue(actual.contains(HRYVNIA));
    }
}
