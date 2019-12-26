/**
 * Package for testing OpenCart website.
 */
package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AdminAddNewItemTest extends AdminLocalTestRunner {

    /**
     * Switch to tab by tab name.
     *
     * @param tabName tab name.
     */
    protected void switchTabByPartialName(final String tabName) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().toLowerCase()
                    .contains(tabName.toLowerCase())) {
                break;
            }
        }
    }

    /**
     * Checking if there is "Nokia 3310" item in "OpenCart" site
     * Add new item "Nokia 3310" from admin page
     * Checking if new item "Nokia 3310" was added, in "OpenCart" site
     * Deleting this item in admin panel
     * Checking if there is "Nokia 3310" item in "OpenCart" site.
     *
     * @throws Exception exception
     */
    @Test
    public void addNewItemCaseOne() throws Exception {

        driver.get("http://192.168.216.128/opencart/upload/");
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Nokia 3310");
        //
        // Clicking on the "Search" button
        driver.findElement(By.
                cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains(
                "There is no product that matches the search criteria."));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Open new tab "Administration" and switch to it
        ((JavascriptExecutor) driver).executeScript(
                "window.open('http://192.168.216.128/opencart/upload/admin/',"
                        + " '_blank');");
        switchTabByPartialName("Administration");
        //Login
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("admin");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).
                sendKeys(System.getenv().get("ADMIN_PASSWORD"));
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.xpath("//button")).click();
        //
        // Opening left-side menu
        driver.findElement(By.id("menu-catalog")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Clicking on "Products"
        driver.findElement(By.xpath("//li[@id='menu-catalog']"
                + "//a[contains(@href, 'product')]")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Clicking on "Add" button
        driver.findElement(By.xpath("//div[@class='pull-right']"
                + "//a[contains(@href, 'add')]")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Typing "Product Name"
        driver.findElement(By.id("input-name1")).click();
        driver.findElement(By.id("input-name1")).clear();
        driver.findElement(By.id("input-name1")).sendKeys("Nokia 3310");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Typing "Description"
        driver.findElement(By.
                xpath("//div[@class = 'note-editable panel-body']")).click();
        driver.findElement(By.
                xpath("//div[@class = 'note-editable panel-body']")).clear();
        driver.findElement(By.
                xpath("//div[@class = 'note-editable panel-body']")).
                sendKeys(DESCRIPTION);
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Typing "Meta Tag Title"
        driver.findElement(By.id("input-meta-title1")).click();
        driver.findElement(By.id("input-meta-title1")).clear();
        driver.findElement(By.id("input-meta-title1")).sendKeys("Nokia 3310");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Typing "Model" and "Price"
        driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
        driver.findElement(By.id("input-model")).sendKeys("3310");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.id("input-price")).sendKeys("10");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Checking item was successfully added
        WebElement actual = driver.findElement(By.
                xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(actual.getText().
                contains("Success: You have modified products!"));
        // Switching to OpenCart and checking if item was added
        switchTabByPartialName("Your Store");
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Nokia 3310");
        // Clicking on the "Search" button
        driver.findElement(By.
                cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Nokia 3310']"));
        Assert.assertTrue(item.getText().contains("Nokia 3310"));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Switching to the "Administration" tab
        switchTabByPartialName("Products");
        // Opening left-side menu and clicking on "Products"
        driver.findElement(By.id("menu-catalog")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.xpath("//li[@id='menu-catalog']"
                 + "//a[contains(@href, 'product')]")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Finding "Nokia 3310" item
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).sendKeys("Nokia 3310");
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.id("button-filter")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Selecting item and deleting it
        driver.findElement(By.
                xpath("//thead//input[@type='checkbox']")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        driver.findElement(By.
                xpath("//button[@data-original-title = 'Delete']")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Clicking "OK" on alert
        driver.switchTo().alert().accept();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Return to Previous State
        driver.findElement(By.xpath("//img[@title='OpenCart']")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Logout
        driver.findElement(By.xpath("//ul[@class ='nav pull-right']"
                + "//a[contains(@href, 'logout')]")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        switchTabByPartialName("Your Store");
        // Checking if the item was deleted
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Nokia 3310");
        // Clicking on the "Search Button"
        driver.findElement(By.
                cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Checking
        WebElement detetedItem = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(detetedItem.getText().contains(
                "There is no product that matches the search criteria."));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
    }
}
