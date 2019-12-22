package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListAndGridTest extends LocalTestRunner {

    //Grid button
    //@Test
    public void caseOne() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iPhone");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        // Clicking on the "Grid" button
        driver.findElement(By.id("grid-view")).click();
        Assert.assertTrue(driver.findElement(By.id("grid-view")).getAttribute("class").equals("btn btn-default active"));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }

    //List button
    @Test
    public void caseTwo() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iPhone");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        // Clicking on the "Grid" button
        driver.findElement(By.id("list-view")).click();
        Assert.assertTrue(driver.findElement(By.id("list-view")).getAttribute("class").equals("btn btn-default active"));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }

}
