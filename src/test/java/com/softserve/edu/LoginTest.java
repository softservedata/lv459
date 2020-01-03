package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Opencart login tests.
 *
 */
public class LoginTest extends LoginTestRunner {

    /**
     * This method testing logination with correct credentials.
     * @throws InterruptedException
     */
    @Test
    public void loginTest() throws InterruptedException {
        login(System.getenv("OPENCART_LOGIN_TWO"),
                System.getenv("OPENCART_PASSWORD"));
        //
        driver.findElement(
                By.cssSelector(".list-unstyled a[href*='account/edit']"))
                .click();
        //
        assertEquals(System.getenv().get("OPENCART_LOGIN_TWO"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
    }

    /**
     * This method testing login with wrong credentials.
     * @throws InterruptedException
     */
    @Test
    public void incorrectPasswordLoginTest() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            login(System.getenv("OPENCART_LOGIN_TWO"), "wrongpassword");
        }
        //
        assertEquals(
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.className("alert-danger")).getText());
    }
}
