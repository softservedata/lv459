package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class LoginTest extends LocalTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] customers() {
        return new Object[][] {
            { UserRepository.get().getCorrectUser() },
        };
    }

    @Test(dataProvider = "customers")
    public void loginTest(IUser validUser) {
      String email =  loadApplication()
        .gotoLoginPage()
        .successfulLogin(validUser)
        .gotoEditAccountRight()
        .getEmailFieldText();
      Assert.assertEquals(email, validUser.getEmail());
    }

}
