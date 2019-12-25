package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminAddNewItemTest extends AdminLocalTestRunner{


    protected void switchTabByPartialName(String tabName) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().toLowerCase()
                    .contains(tabName.toLowerCase())) {
                break;
            }
        }
    }
    /**
     * Add new item from admin page, check this item in customer page, and delete in admin panel
     */
    @Test
    public void addNewItemCaseOne() throws Exception {
        //Login
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
        driver.findElement(By.id("input-model")).sendKeys("3310");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.id("input-price")).sendKeys("10");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);// For Presentation Only


        // Checking

        WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(actual.getText().contains("Success: You have modified products!"));



        driver.findElement(By.xpath("//i[@class='fa fa-home fa-lg']")).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href, 'upload')]")).click();
        Thread.sleep(2000);// For Presentation Only
        switchTabByPartialName("Your Store");

        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Nokia 3310");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(2000); // For Presentation Only
        //
        // Checking
        WebElement macBook = driver.findElement(By.xpath("//a[text()='Nokia 3310']"));
        Assert.assertTrue(macBook.getText().contains("Nokia 3310"));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(2000); // For Presentation Only

        switchTabByPartialName("Products");




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

        //
        driver.findElement(By.xpath("//img[@title='OpenCart']")).click();
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(By.xpath( "//ul[@class ='nav pull-right']//a[contains(@href, 'logout')]")).click();
        Thread.sleep(2000);// For Presentation Only
    }
}
