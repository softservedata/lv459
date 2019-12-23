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
        Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys( System.getenv().get("ADMIN_PASSWORD"));
        Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.xpath("//button")).click();
        //
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(@href, 'product')]")).click();
        //
        driver.findElement(By.xpath("//div[@class='pull-right']//a[contains(@href, 'add')]")).click();
        //
        driver.findElement(By.id("input-name1")).click();
        driver.findElement(By.id("input-name1")).clear();
        driver.findElement(By.id("input-name1")).sendKeys("Nokia 3310");
        //
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).click();
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).clear();
        driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).sendKeys("The Nokia 3310 is a GSM mobile phone announced on 1 September 2000, and released in the fourth quarter of the year, replacing the popular Nokia 3210.");
        //
        driver.findElement(By.id("input-meta-title1")).click();
        driver.findElement(By.id("input-meta-title1")).clear();
        driver.findElement(By.id("input-meta-title1")).sendKeys("Nokia 3310");
        //
        driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
        driver.findElement(By.id("input-model")).sendKeys("Nokia 3310");
        driver.findElement(By.id("input-price")).sendKeys("10");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(@href, 'product')]")).click();
        //
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).sendKeys("Nokia 3310");
        //
        driver.findElement(By.id("button-filter")).click();
        //
        driver.findElement(By.xpath("//thead//input[@type='checkbox']")).click();
        //
        driver.findElement(By.xpath("//button[@data-original-title = 'Delete']")).click();
        //
        driver.switchTo().alert().accept();






        driver.findElement(By.xpath( "//ul[@class ='nav pull-right']//a[contains(@href, 'logout')]")).click();

/*        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains("There is no product that matches the search criteria."));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(2000);// For Presentation Only*/
    }
}
