package com.softserve.edu.admin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class was implemented to run tests via admin panel.
 */
public class AdminTest extends LocalTestRunner {
    /**
     * This test was created to check if the new currency was created.
     */
    @Test
    public void addNewCurrency() {
        driver.findElement(By.xpath("//*[@data-original-title='Add New']"))
                .click();
        //Sends the required fields to create a new currency.
        sendsNewCurrencyValues();
        driver.findElement(By.xpath("//*[@data-original-title='Save']"))
                .click();
        WebElement new_title = driver.findElement(By.xpath("//table[@class='table " +
                "table-bordered table-hover']//tbody//td[contains(text(), 'Grivnya')]"));
        Assert.assertEquals("Grivnya", new_title.getText());
    }

    /**
     * This test was created to check if the new currency was created properly (Taxes are included in the price).
     */
    @Test
    public void checkNewCurrencyExAsUserTax() {
        //WITH TAXES
        System.out.println("\t@Before method");
        driver.get("http://192.168.5.129/opencart/upload/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='UAH']")).click();
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        String price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']")).getText();
        Assert.assertTrue(price.contains("15,050.00"));
    }

    /**
     * This test was created to check if the new currency was created properly(no taxes included in the price).
     */
    @Test
    public void checkNewCurrencyExAsUser() {
        //NO TAXES
        System.out.println("\t@Before method");
        driver.get("http://192.168.5.129/opencart/upload/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='UAH']")).click();
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']/span")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("12,500.00", price.substring(m.start(), m.end()));
        }
    }

    /**
     * This private method sends required fields to create a new currency.
     */
    private void sendsNewCurrencyValues() {
        driver.findElement(By.id("input-title")).click();
        driver.findElement(By.id("input-title")).clear();
        driver.findElement(By.id("input-title")).sendKeys("Grivnya");

        driver.findElement(By.id("input-code")).click();
        driver.findElement(By.id("input-code")).clear();
        driver.findElement(By.id("input-code")).sendKeys("UAH");

        driver.findElement(By.id("input-symbol-right")).click();
        driver.findElement(By.id("input-symbol-right")).clear();
        driver.findElement(By.id("input-symbol-right")).sendKeys("₴");

        driver.findElement(By.id("input-decimal-place")).click();
        driver.findElement(By.id("input-decimal-place")).clear();
        driver.findElement(By.id("input-decimal-place")).sendKeys("2");

        driver.findElement(By.id("input-value")).click();
        driver.findElement(By.id("input-value")).clear();
        driver.findElement(By.id("input-value")).sendKeys("25");

        driver.findElement(By.id("input-status")).click();
        driver.findElement(By.xpath("//*[@id='input-status']/option[contains(text(), 'Enabled')]")).click();
    }
}
