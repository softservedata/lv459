package com.softserve.edu;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
        //
        driver.findElement(By.partialLinkText("Login")).click();
        //
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(
                System.getenv().get("OPENCART_LOGIN_TWO"), Keys.ARROW_LEFT);
        //
        Thread.sleep(1000); // For Presentation Only

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_PASSWORD"), Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.xpath("//*[contains(text(), \'Edit your account information\')]")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        assertEquals("Andry", driver.findElement(By.id("input-firstname")).getAttribute("value"));
        assertEquals("Lastname", driver.findElement(By.id("input-lastname")).getAttribute("value"));
        Thread.sleep(4000); // For Presentation Only
        driver.quit();
    }
}
