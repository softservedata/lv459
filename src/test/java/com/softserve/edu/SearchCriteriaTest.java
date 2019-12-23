package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class SearchCriteriaTest extends LocalTestRunner {

    @Test
    public void searchCriteriaCaseOne() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("Samsung SyncMaster 941BW");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name("category_id")).click();
        //Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("Components" + Keys.ENTER);
        //Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.id("description")).click();
        driver.findElement(By.className("checkbox-inline")).click();
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement samsung = driver.findElement(By.xpath("//a[text()='Samsung SyncMaster 941BW']"));
        Assert.assertTrue(samsung.getText().contains("Samsung SyncMaster 941BW"));

        Thread.sleep(2000);// For Presentation Only
        // Checking description
        driver.findElement(By.xpath("//a[text()='Samsung SyncMaster 941BW']")).click();
        WebElement description = driver.findElement(By.xpath("//h1[contains(text(), 'Samsung SyncMaster 941BW')]"));
        Assert.assertTrue(description.getText().contains("Samsung SyncMaster 941BW"));
        // Checking category
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']/following-sibling::a[contains(text(), 'Show All Components')]")).click();
        Thread.sleep(1000);// For Presentation Only
        //In category
        WebElement item = driver.findElement(By.xpath("//div[@class='col-sm-3']//a[contains(text(), 'Monitors')]"));
        Assert.assertTrue(item.getText().contains("Monitors"));
        //
        driver.findElement(By.xpath("//div[@class='col-sm-3']//a[contains(text(), 'Monitors')]")).click();
        //In subcategory
        WebElement subcategory = driver.findElement(By.xpath("//a[text()='Samsung SyncMaster 941BW']"));
        Assert.assertTrue(subcategory.getText().contains("Samsung SyncMaster 941BW"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
    }

    @Test
    public void searchCriteriaCaseTwo() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("apple");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name("category_id")).click();
        //Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("All Categories" + Keys.ENTER);
        //Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement apple = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
        //
        // Checking
        WebElement mac = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(mac.getText().contains("MacBook Pro"));

        driver.findElement(By.xpath("//a[text()='MacBook Pro']")).click();
        WebElement paragraph = driver.findElement(By.xpath("//p[contains(text(), 'Apple')]"));
        Assert.assertTrue(paragraph.getText().contains("Apple"));
        //
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']//a[contains(text(), 'Monitors')]")).click();
        Thread.sleep(1000);// For Presentation Only
        WebElement applecinema = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(applecinema.getText().contains("Apple Cinema 30\""));
        //
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Laptops & Notebooks')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']/following-sibling::a[contains(text(), 'Show All Laptops & Notebooks')]")).click();
        Thread.sleep(1000);// For Presentation Only
        WebElement macbook = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(macbook.getText().contains("MacBook Pro"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
    }

    @Test
    public void searchCriteriaCaseThree() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name("category_id")).click();
        //Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("Monitors" + Keys.ENTER);
        //Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.className("checkbox-inline")).click();
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']//a[contains(text(), 'Monitors')]")).click();
        Thread.sleep(1000);// For Presentation Only
        WebElement apple = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
    }

    @Test
    public void searchCriteriaCaseFour() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name("category_id")).click();
        //Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("Monitors" + Keys.ENTER);
        //Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.className("checkbox-inline")).click();
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']//a[contains(text(), 'Monitors')]")).click();
        Thread.sleep(1000);// For Presentation Only
        WebElement apple = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
    }

    @Test
    public void searchCriteriaCaseFive() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name("category_id")).click();
        //Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("Monitors" + Keys.ENTER);
        //Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']//a[contains(text(), 'Monitors')]")).click();
        Thread.sleep(1000);// For Presentation Only
        WebElement apple = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
    }

    @Test
    public void searchCriteriaCaseSix() throws Exception {
        // Steps
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
        driver.findElement(By.id("input-search")).sendKeys("Samsung Galaxy Tab 10.1");
        //
        // Clicking on the "Search" button and "Search in product descriptions" checkbox
        driver.findElement(By.cssSelector("#content > p > label")).click();
        Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement samsung = driver.findElement(By.xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(samsung.getText().contains("Samsung Galaxy Tab 10.1"));
        //
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy Tab 10.1']")).click();
        WebElement header = driver.findElement(By.xpath("//div[@class='col-sm-4']//h1"));
        WebElement samsungText = driver.findElement(By.cssSelector("#tab-description p:first-child"));
        Assert.assertTrue(samsungText.getText().contains(header.getText()));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
       // Assert.assertEquals(samsungText, header);
   /*     WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());*/
        //Thread.sleep(2000);// For Presentation Only
    }

    @Test
    public void searchCriteriaCaseSeven() throws Exception {
        // Steps
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
        driver.findElement(By.id("input-search")).sendKeys("Samsung Galaxy Tab 10.1");
        //
        // Clicking on the "Search" button
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(1000);// For Presentation Only
        //
        // Checking
        WebElement samsung = driver.findElement(By.xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(samsung.getText().contains("Samsung Galaxy Tab 10.1"));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(2000);// For Presentation Only
    }

    @Test
    public void searchCriteriaCaseEight() throws Exception {
        // Steps
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
        //Thread.sleep(2000);// For Presentation Only
    }

}
