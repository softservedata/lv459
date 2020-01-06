package com.softserve.edu.ua;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class was implemented to run test for user with NO taxes.
 */
public class UaUserTest extends LocalTestRunnerUa {

    /**
     * This test checks the price of the item.
     */
    @Test
    public void checkUsCurrency() {
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']/span")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("500.00", price.substring(m.start(), m.end()));
        }
    }

    /**
     * This method was implemented to check if another currency works as intended.
     */
    @Test
    public void checkEuCurrency() {
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='EUR']")).click();
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']/span")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("392.30", price.substring(m.start(), m.end()));
        }
    }

    /**
     * Check the cart if the price inside is correct.
     */
    @Test
    public void checkUsCart() {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//" +
                "button[contains(@onclick, 'cart')]")).click();
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//*[@id='cart']//span")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("500.00", price.substring(m.start(), m.end()));
        }
    }

    /**
     * Check the wish list if the price inside is correct.
     */
    @Test
    public void checkUsWish() {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//" +
                "button[@data-original-title='Add to Wish List']")).click();
        driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//" +
                "td/div[contains(text(), '$500.00')]")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("500.00", price.substring(m.start(), m.end()));
        }
    }
}
