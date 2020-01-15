package com.softserve.edu.opencart.tests;

import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.UserRepository;

public class RestorePasswordTest extends LocalEmailTestRunner {

    @Test
    public void changePasswordTest(){
        loadApplication().successfulLogin(UserRepository.get().getEmailUser())
        .goToIncomingMwssages()
        .goToRestorePasswordMessage("Password reset")
        .clickRestorePasswordLink();
    }
}
