package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Duration;
import java.time.Instant;



public class SearchItemsTest extends LocalTestRunner {

    //Using lower/upper case letters, numbers and symbol
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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

    //SQL command
    @Test
    public void findItemCaseNine() throws Exception {
        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("; DROP DATABASE *;");
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
    @Test
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
    @Test
    public void fieldLengthCaseTwo() throws Exception {
        //Read with FileChannel

        String file = "D:\\All\\IT\\Lv-459\\4097.txt";
        RandomAccessFile reader = new RandomAccessFile(file, "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();


        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        Instant start = Instant.now();
        driver.findElement(By.name("search")).sendKeys(new String(buff.array()));

        channel.close();
        reader.close();


        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);

        System.out.println("Execution time in seconds: " +
                interval.getSeconds());
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Checking
 //       WebElement zeroLength = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
 //       Assert.assertTrue(zeroLength.getText().contains("There is no product that matches the search criteria."));
        //
        // Return to Previous State
//        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(1000); // For Presentation Only
    }

    //65536 letters in "Search field"
     @Test
    public void fieldLengthCaseThree() throws Exception {

       String strCharacter = "abcdefghijklmnopqrstuvwxyz_" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" +
                "0123456789";
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0; i < 1024; i++){
            stringBuffer.append(strCharacter);
        }

        // Steps
        // Typing in the "Search field"
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(stringBuffer.toString());
        //
        // Clicking on the "Search Button"
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000); // For Presentation Only
         //
         // Checking
         WebElement item = driver.findElement(By.xpath("//h1[contains(text(), 'Request-URI Too Long')]"));
         Assert.assertTrue(item.getText().contains("Request-URI Too Long"));
        //
        // Return to Previous State
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //Thread.sleep(1000); // For Presentation Only
    }
}
