package com.softserve.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItemsTest extends LocalTestRunner {

    //Using lower/upper case letters, numbers and symbol
    //@Test
    public void findItemCaseOne() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement macBook = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(macBook.getText().contains("Apple Cinema 30\""));
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }

    //Using lower/upper case letters
    //@Test
    public void findItemCaseTwo() throws Exception {
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

    //Using lower case letters and number
    //@Test
    public void findItemCaseThree() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("te9");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Samsung - Galaxy Note9']"));
        Assert.assertTrue(item.getText().contains("Samsung - Galaxy Note9"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }

    //Using lower case letters and symbol
    //@Test
    public void findItemCaseFour() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("pp \"");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
       // Thread.sleep(1000); // For Presentation Only
    }

    //Using upper case letters and numbers
    //@Test
    public void findItemCaseFive() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("V600");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Epson - Perfection V600']"));
        Assert.assertTrue(item.getText().contains("Epson - Perfection V600"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        // Thread.sleep(1000); // For Presentation Only
    }

    //Using upper case letters and symbol
    //@Test
    public void findItemCaseSix() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("A \"");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        // Thread.sleep(1000); // For Presentation Only
    }

    //Using numbers and symbol
    @Test
    public void findItemCaseSeven() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("30\"");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        // Thread.sleep(1000); // For Presentation Only
    }

    //Empty field
    //@Test
    public void findItemCaseEight() throws Exception {
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

    //One letter in "Search field"
    //@Test
    public void fieldLengthCaseOne() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("q");
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000); // For Presentation Only
    }

    //255 letters in "Search field"
   // @Test
    public void fieldLengthCaseTwo() throws Exception {


        File file = new File("D:\\All\\IT\\Lv-459\\lv459-selenium\\255.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(br.readLine());
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(3000); // For Presentation Only

        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(1000); // For Presentation Only
    }

    //65536 letters in "Search field"
     @Test
    public void fieldLengthCaseThree() throws Exception {


        File file = new File("D:\\All\\IT\\Lv-459\\lv459-selenium\\65536.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(br.readLine());
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(3000); // For Presentation Only

        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(1000); // For Presentation Only
    }
}
