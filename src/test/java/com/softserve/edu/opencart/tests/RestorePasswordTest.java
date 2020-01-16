package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class RestorePasswordTest extends LocalEmailTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctCustomers() {
        return new Object[][] {
            { UserRepository.get().getEmailUser() },
        };
    }

    @Test(dataProvider = "correctCustomers")
    public void changePasswordTest(IUser validUser){
        loadApplication()
        .gotoLoginPage().
        forgotPassword()
        .enterEmail(validUser);
        
        loadEmailPage()
        .successfulLogin(validUser)
        .goToIncomingMwssages()
        .goToRestorePasswordMessage("Password reset")
        .clickRestorePasswordLink();
    }
}
