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
        login(System.getenv().get("OPENCART_LOGIN_TWO"),
                System.getenv().get("OPENCART_PASSWORD"));
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(
                By.cssSelector(".list-unstyled a[href*='account/edit']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        assertEquals(System.getenv().get("OPENCART_LOGIN_TWO"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
        Thread.sleep(4000); // For Presentation Only
    }

    /**
     * This method testing login with wrong credentials.
     * @throws InterruptedException
     */
    @Test
    public void incorrectPasswordLoginTest() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            login(System.getenv().get("OPENCART_LOGIN_TWO"), "wrongpassword");
        }
        //
        Thread.sleep(1000); // For Presentation Only
        assertEquals(
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.className("alert-danger")).getText());
        Thread.sleep(4000); // For Presentation Only
    }
}
