package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class LoginTest extends LocalTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctCustomers() {
        return new Object[][] {
            { UserRepository.get().getCorrectUser() },
        };
    }
    
    @DataProvider // (parallel = true)
    public Object[][] incorrectCustomers() {
        return new Object[][] {
            { UserRepository.get().getIncorrectUser() },
        };
    }
/**
 * This test try login with correct credentials and verify that we go to the right customer.
 * @param validUser - user with correct credentials
 */
    @Test(dataProvider = "correctCustomers", priority = 1)
    public void loginTest(IUser validUser) {
      String email =  loadApplication()
        .gotoLoginPage()
        .successfulLogin(validUser)
        .gotoEditAccountRight()
        .getEmailFieldText();
      Assert.assertEquals(email, validUser.getEmail());
    }
    
    /**
     * This test try to login with incorrect credentials and verify error message.
     * @param invalidUser - user with incorrect credentials.
     */
    @Test(dataProvider = "incorrectCustomers", priority = 2)
    public void incorrectUserLoginTest(IUser invalidUser) {
      String warningMessage =  loadApplication()
        .gotoLoginPage()
        .unsuccessfulLogin(invalidUser)
        .unsuccessfulLogin(invalidUser)
        .unsuccessfulLogin(invalidUser)
        .unsuccessfulLogin(invalidUser)
        .unsuccessfulLogin(invalidUser)
        .unsuccessfulLogin(invalidUser)
        .getAlertWarningText();
      Assert.assertEquals(warningMessage, BLOCK_USER_ERROR_MESSAGE);
    }

}
