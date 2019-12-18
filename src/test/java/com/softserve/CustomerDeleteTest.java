package com.softserve;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CustomerDeleteTest extends LocalTestRunnerAdminPanel {

    @Test
    public void deleteCustomerTest() throws Exception {

        // Prerequisites - login as administrator, customer with USER_EMAIL exists in DB.

        //prerequisites start - create customer

       prerequisitesCreateCustomer();

        // prerequisites finish

        driver.findElement(By.id("menu-customer")).click();
        driver.findElement(By.xpath("//a[.='Customers']")).click();

        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(System.getenv("USER_EMAIL"));
        driver.findElement(By.id("button-filter")).click();
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.className("btn-danger")).click();

        Thread.sleep(DELAY);

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.xpath(
                "//*[contains(text(),'Success: You have modified customers!')]"))
                .getText().contains("You have modified customers!"));
        Thread.sleep(DELAY*2);

    }

    private void prerequisitesCreateCustomer (){
        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://172.16.0.128/opencart/upload/");
        webdriver.findElement(By.className("dropdown")).click();
        webdriver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        webdriver.findElement(By.id("input-firstname")).clear();
        webdriver.findElement(By.id("input-firstname")).sendKeys("Se");

        webdriver.findElement(By.id("input-lastname")).clear();
        webdriver.findElement(By.id("input-lastname")).sendKeys("Pe");

        webdriver.findElement(By.id("input-email")).clear();
        webdriver.findElement(By.id("input-email")).sendKeys(System.getenv("USER_EMAIL"));

        webdriver.findElement(By.id("input-telephone")).clear();
        webdriver.findElement(By.id("input-telephone")).sendKeys("123");

        webdriver.findElement(By.id("input-fax")).clear();
        webdriver.findElement(By.id("input-fax")).sendKeys("456");

        // Filling section "Your address"
        webdriver.findElement(By.id("input-company")).clear();
        webdriver.findElement(By.id("input-company")).sendKeys("SoftServe");

        webdriver.findElement(By.id("input-address-1")).clear();
        webdriver.findElement(By.id("input-address-1")).sendKeys("abc");

        webdriver.findElement(By.id("input-address-2")).clear();
        webdriver.findElement(By.id("input-address-2")).sendKeys("abc2");

        webdriver.findElement(By.id("input-city")).clear();
        webdriver.findElement(By.id("input-city")).sendKeys("Lemberg");

        webdriver.findElement(By.id("input-postcode")).clear();
        webdriver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(((ChromeDriver) webdriver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(((ChromeDriver) webdriver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");

        // Filling section "Your Password"
        webdriver.findElement(By.id("input-password")).clear();
        webdriver.findElement(By.id("input-password")).sendKeys(System.getenv("USER_PASSWORD"));
        webdriver.findElement(By.id("input-confirm")).clear();
        webdriver.findElement(By.id("input-confirm")).sendKeys(System.getenv("USER_PASSWORD"));
        webdriver.findElement(By.name("agree")).click();
        webdriver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
        webdriver.quit();
    }
}
