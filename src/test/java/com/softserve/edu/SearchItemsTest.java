package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItemsTest {

    //@Test
    public void findMacBook() throws Exception {
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

    @Test
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
}
