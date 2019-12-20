package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginTest extends LoginationTestRunner {

    @Test
    public void loginTest() throws InterruptedException {
        
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        //
        driver.findElement(By.cssSelector(
                ".dropdown-menu.dropdown-menu-right a[href*='account/login']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(
                System.getenv().get("OPENCART_LOGIN_TWO"), Keys.ARROW_LEFT);
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_PASSWORD"), Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        //
        Thread.sleep(1000); // For Presentation Only
        //
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
            driver.findElement(By.id("input-email")).click();
            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(
                    System.getenv().get("OPENCART_LOGIN_ONE"), Keys.ARROW_LEFT);
            //

            driver.findElement(By.id("input-password")).click();
            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password"))
                    .sendKeys("SuperStrongPassword", Keys.ARROW_LEFT);
            driver.findElement(By.id("input-password")).submit();
        }
        //
        Thread.sleep(1000); // For Presentation Only
        assertEquals(
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.className("alert-danger")).getText());
        Thread.sleep(4000); // For Presentation Only
    }
}
