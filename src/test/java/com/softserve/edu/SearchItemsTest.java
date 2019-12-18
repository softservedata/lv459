package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItemsTest extends LocalTestRunner {

    //@Test
    public void findMacBook() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("MacBook");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement macBook = driver.findElement(By.xpath("//a[text()='MacBook']"));
        Assert.assertTrue(macBook.getText().contains("MacBook"));
        //
        // Checking
        WebElement macBookAir = driver.findElement(By.xpath("//a[text()='MacBook Air']"));
        Assert.assertTrue(macBookAir.getText().contains("MacBook Air"));
        //
        // Checking
        WebElement macBookPro = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(macBookPro.getText().contains("MacBook Pro"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }
    //@Test
    public void testAsterisk() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.get("http://192.168.216.128/opencart/upload/");
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("*" + Keys.ENTER);

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(1000);// For Presentation Only
        driver.quit();
    }

    //@Test
    public void testEmptyField() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.get("http://192.168.216.128/opencart/upload/");
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("" + Keys.ENTER);

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(1000);// For Presentation Only
        driver.quit();
    }

    //@Test
    public void testNumberThree() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("3" + Keys.ENTER);

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(1000);// For Presentation Only
        driver.quit();
    }

    //@Test
    public void testSemicolon() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.get("http://192.168.216.128/opencart/upload/");
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(";" + Keys.ENTER);

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(1000);// For Presentation Only
        driver.quit();
    }

    //@Test
    public void testMacBook() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.216.128/opencart/upload/");
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        //
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("MacBook" + Keys.ENTER);

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/label"));
        Assert.assertEquals("Search Criteria", actual.getText());
        Thread.sleep(2000);// For Presentation Only
        driver.quit();
    }

    //@Test
    public void fieldLengthCaseOne() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains("There is no product that matches the search criteria."));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }
    //@Test
    public void fieldLengthCaseTwo() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("z");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains("There is no product that matches the search criteria."));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }
}
