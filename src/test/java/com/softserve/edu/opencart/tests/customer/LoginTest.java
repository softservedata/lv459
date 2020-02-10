package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.tests.LocalAdminSingleThreadRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends LocalAdminSingleThreadRunner {

    @DataProvider // (parallel = true)
    public Object[][] correctCustomers() {
        return new Object[][] {
                {UserRepository.get().getCorrectUser()},
                };
    }

    /**
     * This test try login with correct credentials and verify that we go to the right customer.
     *
     * @param validUser - user with correct credentials
     */
    @Test(dataProvider = "correctCustomers", priority = 1)
    public void loginTest(IUser validUser) {
        String firstName = loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .getValueFirstNameText();

        Assert.assertEquals(firstName, validUser.getFirstName());
    }
}
