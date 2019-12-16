package com.softserve.edu;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void loginTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", this.getClass()
                .getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000); // For Presentation Only
        //
        driver.get("http://192.168.214.128/opencart/upload/");
        Thread.sleep(1000); // For Presentation Only
        //
        WebElement login = driver
                .findElement(By.xpath("//a[contains(text(), 'Login')]"));
        //
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                login);
        //
        Thread.sleep(1000); // For Presentation Only
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
        //
        Thread.sleep(1000); // For Presentation Only
        assertNotNull(driver
                .findElement(By.xpath("//a[contains(text(), 'Logout')]")));
        Thread.sleep(4000); // For Presentation Only
        driver.quit();
    }
}
