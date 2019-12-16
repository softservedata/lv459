package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectPasswordTest {

    @Test
    public void incorrectPasswordTest() throws InterruptedException {
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
        driver.quit();
    }
}
