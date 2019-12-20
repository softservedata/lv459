package com.softserve.edu;

import org.junit.Test;

public class RestorePasswordTest extends RestorePasswordRunner {

    @Test
    public void restorePasswordTest() throws Exception {
        changePassword(System.getenv("OPENCART_PASSWORD_RESTORE_NEW"));
        //
        Thread.sleep(1000);
        //
        login(System.getenv("OPENCART_LOGIN_RESTORE"),
                System.getenv("OPENCART_PASSWORD_RESTORE_NEW"));
        //
        Thread.sleep(1000);
        //
        logout();
        Thread.sleep(1000);
        //
        changePassword(System.getenv("OPENCART_PASSWORD_RESTORE"));
        //
        Thread.sleep(1000);
        //
        login(System.getenv("OPENCART_LOGIN_RESTORE"),
                System.getenv("OPENCART_PASSWORD_RESTORE"));
        Thread.sleep(4000);
    }
}
