package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginTest extends LoginationTestRunner {

    @Test
    public void loginTest() throws InterruptedException {

        login(System.getenv().get("OPENCART_LOGIN_TWO"),
                System.getenv().get("OPENCART_PASSWORD"));
        driver.findElement(
                By.cssSelector(".list-unstyled a[href*='account/edit']"))
                .click();
        Thread.sleep(1000); // For Presentation Only
        //
        assertEquals(System.getenv().get("OPENCART_LOGIN_TWO"),
                driver.findElement(By.id("input-email")).getAttribute("value"));
        Thread.sleep(4000); // For Presentation Only
    }

    @Test
    public void incorrectPasswordLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
        //
        driver.findElement(By.cssSelector(
                ".dropdown-menu.dropdown-menu-right a[href*='account/login']"))
                .click();
        Thread.sleep(1000); // For Presentation Only
        for (int i = 0; i < 6; i++) {
            login(System.getenv().get("OPENCART_LOGIN_TWO"),
                    System.getenv().get("OPENCART_PASSWORD"));
        }
        //
        Thread.sleep(1000); // For Presentation Only
        assertEquals(
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.className("alert-danger")).getText());
        Thread.sleep(4000); // For Presentation Only
    }
}
