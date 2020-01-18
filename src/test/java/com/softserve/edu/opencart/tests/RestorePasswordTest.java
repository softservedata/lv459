package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class RestorePasswordTest extends LocalEmailTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctCustomers() {
        return new Object[][] {
            { UserRepository.get().emailUser() },
        };
    }

    @Test(dataProvider = "correctCustomers", priority = 1)
    public void changePasswordTest(IUser validUser){
        loadApplication()
        .gotoLoginPage()
        .forgotPassword()
        .enterEmail(validUser);
        
     String email = loadEmailPage()
        .successfulLogin(validUser)
        .goToIncomingMwssages()
        .goToRestorePasswordMessage(RESET_PASSWORD_MESSAGE)
        .clickRestorePasswordLink()
        .enterNewPassword(validUser)
        .successfulLogin(validUser)
        .gotoEditAccountRight().getEmailFieldText();
     
     Assert.assertEquals(validUser.getEmail(), email);

    }
    
    @Test(dataProvider = "correctCustomers", priority = 2)
    public void restorePasswordTest(IUser validUser){
        loadApplication()
        .gotoLoginPage()
        .forgotPassword()
        .enterEmail(validUser);
        
     String email = loadEmailPage()
        .successfulLogin(validUser)
        .goToIncomingMwssages()
        .goToRestorePasswordMessage("Password reset")
        .clickRestorePasswordLink()
        .enterNewPassword(validUser)
        .successfulLogin(validUser)
        .gotoEditAccountRight()
        .getEmailFieldText();
     
     Assert.assertEquals(validUser.getEmail(), email);

    }
}
