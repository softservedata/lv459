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
        ((JavascriptExecutor) driver)
                .executeScript("window.open('about:blank','_blank');");
        switchTabByPartialName("about");
        login(System.getenv("OPENCART_LOGIN_TWO"),
                System.getenv("OPENCART_PASSWORD"));

        assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.className("alert-danger")).getText());
    }

    /**
     * This method tests unblocked user login.
     * @throws InterruptedException
     */
    @Test
    public void LoginUnblockUserTest() throws InterruptedException {
        switchTabByPartialName("customers");
        changeUserStatus("1");

        switchTabByPartialName("about");
        login(System.getenv("OPENCART_LOGIN_TWO"),
                System.getenv("OPENCART_PASSWORD"));
        //
        driver.findElement(
                By.cssSelector(".list-unstyled a[href*='account/edit']"))
                .click();
        //
        assertEquals(System.getenv("OPENCART_LOGIN_TWO"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
    }

}
