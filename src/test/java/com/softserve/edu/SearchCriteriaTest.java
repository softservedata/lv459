package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchCriteriaTest {

   // @Test
    public void testSearchInProductDescriptions() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.get("http://192.168.216.128/opencart/upload/");
        driver.manage().window().maximize();
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Apple Cinema 30\"" + Keys.ENTER);
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("iPod");

        driver.findElement(By.cssSelector("#content > p > label")).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.id("button-search")).click();
        Thread.sleep(2000);// For Presentation Only
        WebElement Element = driver.findElement(By.id("list-view"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(2000);// For Presentation Only
        driver.quit();
    }

    @Test //assert
    public void testSearchInCategories() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.get("http://192.168.216.128/opencart/upload/");
        driver.manage().window().maximize();
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Apple Cinema 30\"" + Keys.ENTER);

        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).sendKeys("iPod");

        driver.findElement(By.cssSelector("#content > p > label")).click();
        Thread.sleep(2000);// For Presentation Only



        driver.findElement(By.name("category_id")).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.name("category_id")).sendKeys("MP3 Players" + Keys.ENTER);

        driver.findElement(By.className("checkbox-inline")).click();
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(By.id("button-search")).click();
        Thread.sleep(2000);// For Presentation Only
        WebElement Element = driver.findElement(By.id("list-view"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(2000);// For Presentation Only
        driver.quit();
    }
}
