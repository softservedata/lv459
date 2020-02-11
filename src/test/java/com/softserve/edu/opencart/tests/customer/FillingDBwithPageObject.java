package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.AccountLogoutPage;
import com.softserve.edu.opencart.tests.runner.LocalAdminSingleThreadRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FillingDBwithPageObject extends LocalAdminSingleThreadRunner {


    @DataProvider
    private Object[][] getCustomers() {
        return new Object[][]{
                {UserRepository.get().getCorrectUser()},
                {UserRepository.get().getBohdanaUser()},
                {UserRepository.get().getHahaha()},
                {UserRepository.get().getValidCustomer()},
                {UserRepository.get().getYuriiUkUser()},
                {UserRepository.get().getYuriiUaUser()}
        };
    }

    /**
     * Run only once to fill DB with users via Page Object means
     * @param customer
     */
    @Test (dataProvider = "getCustomers")
    private void prerequisites(IUser customer) {

            AccountLogoutPage page = loadMainPage()
                    .gotoRegisterPage()
                    .fillValidCustomerDetails(customer)
                    .gotoHomePage()
                    .logout();
        }

    }

