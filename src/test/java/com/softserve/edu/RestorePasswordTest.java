package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Restore password from email tests.
 */
public class RestorePasswordTest extends RestorePasswordRunner {

    /**
     * Change password and try to login with new credentials.
     * @throws InterruptedException
     */
    @Test
    public void changePasswordTest() throws InterruptedException {
        changePassword(System.getenv("OPENCART_PASSWORD_RESTORE_NEW"));
        //
        Thread.sleep(1000);
        //
        login(System.getenv("OPENCART_LOGIN_RESTORE"),
                System.getenv("OPENCART_PASSWORD_RESTORE_NEW"));
        //
        assertEquals("Wrong account logged",
                System.getenv().get("OPENCART_LOGIN_RESTORE"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
        Thread.sleep(4000);
    }

    /**
     * Restore old password.
     * @throws InterruptedException
     */
    @Test
    public void restorePasswordTest() throws InterruptedException {
        //
        Thread.sleep(1000);
        //
        changePassword(System.getenv("OPENCART_PASSWORD_RESTORE"));
        //
        Thread.sleep(1000);
        //
        login(System.getenv("OPENCART_LOGIN_RESTORE"),
                System.getenv("OPENCART_PASSWORD_RESTORE"));
        //
        assertEquals("Wrong account logged",
                System.getenv().get("OPENCART_LOGIN_RESTORE"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
        Thread.sleep(4000);
    }
}
