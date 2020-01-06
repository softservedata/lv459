package com.softserve.edu.uk;

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
public class UkUserTest extends LocalTestRunnerUk {

    /**
     * This test checks the price of the item(with taxes).
     */
    @Test
    public void checkUsWithTaxCurrency() {
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("602.00"));
    }

    /**
     * This method was implemented to check the price of the item with no taxes.
     */
    @Test
    public void checkUsNoTaxCurrency() {
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
     * This test was implemented to check another currency with taxes.
     */
    @Test
    public void checkEuWithTaxCurrency() {
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='EUR']")).click();
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../" +
                "following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("472.33"));
    }

    /**
     * This test was implemented to check another currency with NO taxes.
     */
    @Test
    public void checkEuNoTaxCurrency() {
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
     * This test was implemented to check currency with taxes inside of the cart.
     */
    @Test
    public void checkUsWithTaxCurrencyCart() {
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
            Assert.assertEquals("602.00", price.substring(m.start(), m.end()));
        }
    }

    /**
     * This test was implemented to check the tax inside of the cart.
     */
    @Test
    public void checkUsTaxCart() {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//" +
                "button[contains(@onclick, 'cart')]")).click();
        driver.findElement(By.xpath("//*[@id='cart']/button")).click();
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String taxprice = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']/li/div//" +
                "tbody//strong[contains(text(), 'VAT')]/../following-sibling::td")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(taxprice);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("100.00", taxprice.substring(m.start(), m.end()));
        }
    }

    /**
     * This test was implemented to check the price with the tax inside of the wish list.
     */
    @Test
    public void checkUsWithTaxWish() {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//" +
                "button[@data-original-title='Add to Wish List']")).click();
        driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String price = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//" +
                "td/div[contains(text(), '$602.00')]")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);
        m.reset();
        while (m.find()) {
            Assert.assertEquals("602.00", price.substring(m.start(), m.end()));
        }
    }
}
