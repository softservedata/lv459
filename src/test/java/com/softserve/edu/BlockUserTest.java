package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Block user from administration panel tests.
 *
 */
public class BlockUserTest extends BlockUserTestRunner {

    /**
     * This method tests blocked user login.
     * @throws InterruptedException
     */
    @Test
    public void loginBlockUserTest() throws InterruptedException {
        changeUserStatus("0");
        Thread.sleep(1000); // For Presentation Only
        ((JavascriptExecutor) driver)
                .executeScript("window.open('about:blank','_blank');");
        Thread.sleep(1000); // For Presentation Only
        switchTabByPartialName("about");
        login(System.getenv().get("OPENCART_LOGIN_TWO"),
                System.getenv().get("OPENCART_PASSWORD"));

        assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.className("alert-danger")).getText());
        Thread.sleep(4000); // For Presentation Only
    }

    /**
     * This method tests unblocked user login.
     * @throws InterruptedException
     */
    @Test
    public void LoginUnblockUserTest() throws InterruptedException {
        switchTabByPartialName("customers");
        Thread.sleep(1000); // For Presentation Only
        changeUserStatus("1");

        Thread.sleep(1000); // For Presentation Only

        switchTabByPartialName("about");
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

}
