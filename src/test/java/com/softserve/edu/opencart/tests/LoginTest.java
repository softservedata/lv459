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

    @Test(dataProvider = "correctCustomers")
    public void loginTest(IUser validUser) {
      String email =  loadApplication()
        .gotoLoginPage()
        .successfulLogin(validUser)
        .gotoEditAccountRight()
        .getEmailFieldText();
      Assert.assertEquals(email, validUser.getEmail());
    }
    
    @Test(dataProvider = "incorrectCustomers")
    public void incorrectUserLoginTest(IUser invalidUser) {
      String warningMessage =  loadApplication()
        .gotoLoginPage()
        .unsuccessfulLogin(invalidUser,6)
        .getAlertWarningText();
      Assert.assertEquals(warningMessage, BLOCK_USER_ERROR_MESSAGE);
    }

}
