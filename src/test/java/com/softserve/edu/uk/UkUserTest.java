package com.softserve.edu.uk;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class UkUserTest extends LocalTestRunnerUk {
    @Test
    public void checkUsWithTaxCurrency() throws Exception {
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("602.00"));
    }

    @Test
    public void checkUsNoTaxCurrency() throws Exception {
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']/span"));
        Assert.assertTrue(price.getText().contains("500.00"));
    }

    @Test
    public void checkEuWithTaxCurrency() throws Exception {
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='EUR']")).click();
        Thread.sleep(1000); // For Presentation Only
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000); // For Presentation Only
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("472.33"));
    }

    @Test
    public void checkEuNoTaxCurrency() throws Exception {
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='EUR']")).click();
        Thread.sleep(1000); // For Presentation Only
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000); // For Presentation Only
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("392.30"));
    }

    @Test
    public void checkUsWithTaxCurrencyCart() throws Exception {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//button[contains(@onclick, 'cart')]")).click();
        Thread.sleep(1000); // For Presentation Only
        WebElement price = driver.findElement(By.xpath("//*[@id='cart']//span"));
        Assert.assertTrue(price.getText().contains("602.00"));
    }

    @Test
    public void checkUsTaxCart() throws Exception {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//button[contains(@onclick, 'cart')]")).click();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//*[@id='cart']/button")).click();
        WebElement taxPrice = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']/li/div//tbody//strong[contains(text(), 'VAT')]/../following-sibling::td"));
        Thread.sleep(1000); // For Presentation Only
        Assert.assertTrue(taxPrice.getText().contains("100.00"));
    }

    @Test
    public void checkUsWithTaxWish() throws Exception {
        WebElement element = driver.findElement(By.id("carousel0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//div[@class='row']//img[@title='MacBook']/../../..//button[@data-original-title='Add to Wish List']")).click();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();
        Thread.sleep(1000); // For Presentation Only
        WebElement price;
        price = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//td/div[contains(text(), '$602.00')]"));
        Assert.assertTrue(price.getText().contains("602.00"));
    }
}
