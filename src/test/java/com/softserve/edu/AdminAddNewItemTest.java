package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminAddNewItemTest extends AdminLocalTestRunner{

    @Test
    public void addNewItemCaseOne() throws Exception {
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("admin");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys( System.getenv().get("ADMIN_PASSWORD"));
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//button")).click();
        //
        driver.findElement(By.id("menu-catalog")).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(@href, 'product')]")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.xpath("//div[@class='pull-right']//a[contains(@href, 'add')]")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.id("input-name1")).click();
        driver.findElement(By.id("input-name1")).clear();
        driver.findElement(By.id("input-name1")).sendKeys("Nokia 3310");
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).click();
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).clear();
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).sendKeys("The Nokia 3310 is a GSM mobile phone announced on 1 September 2000, and released in the fourth quarter of the year, replacing the popular Nokia 3210.");
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.id("input-meta-title1")).click();
        driver.findElement(By.id("input-meta-title1")).clear();
        driver.findElement(By.id("input-meta-title1")).sendKeys("Nokia 3310");
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
        driver.findElement(By.id("input-model")).sendKeys("Nokia 3310");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.id("input-price")).sendKeys("10");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.id("menu-catalog")).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(@href, 'product')]")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).sendKeys("Nokia 3310");
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.id("button-filter")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.xpath("//thead//input[@type='checkbox']")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.findElement(By.xpath("//button[@data-original-title = 'Delete']")).click();
        Thread.sleep(2000);// For Presentation Only
        //
        driver.switchTo().alert().accept();
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(By.xpath( "//ul[@class ='nav pull-right']//a[contains(@href, 'logout')]")).click();
        Thread.sleep(2000);// For Presentation Only
    }
}
