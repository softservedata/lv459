package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BlockUserTest extends BlockUserTestRunner {

    @Test
    public void blockUserTest() throws InterruptedException {
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(
                System.getenv().get("OPENCART_ADMIN_LOGIN"), Keys.ARROW_LEFT);
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_ADMIN_PASSWORD"),
                Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(
                By.cssSelector(".tile-footer a[href*='route=customer']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.xpath(String.format(
                "//td[contains(text(), '%s')] /.. /td[@class='text-right'] /a",
                System.getenv().get("OPENCART_LOGIN_TWO")))).click();
        Thread.sleep(2000); // For Presentation Only
        //
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("input-status")))
                .perform();
        Thread.sleep(2000); // For Presentation Only
        //
        Select select = new Select(driver.findElement(By.id("input-status")));
        select.selectByValue("0");
        Thread.sleep(1000); // For Presentation Only
        //
        action.moveToElement(driver.findElement(By.className("fa-save")))
                .perform();
        driver.findElement(By.className("fa-save")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        ((JavascriptExecutor) driver).executeScript(
                "window.open('http://192.168.214.128/opencart/upload/index.php?route=account/login','_blank');");

        changeTab();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(
                System.getenv().get("OPENCART_LOGIN_TWO"), Keys.ARROW_LEFT);
        //

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_PASSWORD"), Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        Thread.sleep(1000); // For Presentation Only
        //
        assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.className("alert-danger")).getText());
        Thread.sleep(1000); // For Presentation Only
        //
        changeTab();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.xpath(String.format(
                "//td[contains(text(), '%s')] /.. /td[@class='text-right'] /a",
                System.getenv().get("OPENCART_LOGIN_TWO")))).click();
        Thread.sleep(2000); // For Presentation Only
        //
        action.moveToElement(driver.findElement(By.id("input-status")))
                .perform();
        Thread.sleep(2000); // For Presentation Only
        //
        driver.findElement(By.xpath("//select[@id = 'input-status']")).click();
        Thread.sleep(1000);
        select = new Select(driver.findElement(By.id("input-status")));
        select.selectByValue("1");
        //
        Thread.sleep(1000); // For Presentation Only
        //
        action.moveToElement(driver.findElement(By.className("fa-save")))
                .perform();
        driver.findElement(By.className("fa-save")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        changeTab();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(
                System.getenv().get("OPENCART_LOGIN_TWO"), Keys.ARROW_LEFT);
        //

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_PASSWORD"), Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
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
}
