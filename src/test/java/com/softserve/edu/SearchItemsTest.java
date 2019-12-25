/**
 * Package for testing OpenCart website.
 */
package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;


public class SearchItemsTest extends LocalTestRunner {

    /**
     * Typing lower/upper case letters, numbers and symbol
     * in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseOne() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Search" button
        driver.findElement(By.
                cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement macBook = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(macBook.getText().contains("Apple Cinema 30\""));
    }

    /**
     * Typing lower/upper case letters in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseTwo() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("MacBook");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement macBook = driver.findElement(By.
                xpath("//a[text()='MacBook']"));
        Assert.assertTrue(macBook.getText().contains("MacBook"));
        //
        // Checking
        WebElement macBookAir = driver.findElement(By.
                xpath("//a[text()='MacBook Air']"));
        Assert.assertTrue(macBookAir.getText().contains("MacBook Air"));
        //
        // Checking
        WebElement macBookPro = driver.findElement(By.
                xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(macBookPro.getText().contains("MacBook Pro"));
    }

    /**
     * Typing lower case letters and number in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseThree() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("ab 10");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(item.getText().contains("ab 10"));
    }

    /**
     * Typing lower case letters and symbol in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseFour() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("pp \"");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
    }

    /**
     * Typing upper case letters and numbers in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseFive() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("LP3065");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='HP LP3065']"));
        Assert.assertTrue(item.getText().contains("LP3065"));
    }

    /**
     * Typing upper case letters and symbol in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseSix() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("A \"");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
    }

    /**
     * Typing numbers and symbol in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseSeven() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("30\"");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
    }

    /**
     * Empty "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseEight() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains(
                "There is no product that matches the search criteria."));
    }

    /**
     * Typing SQL command in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void findItemCaseNine() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).
                sendKeys("; DROP DATABASE *;");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains(
                "There is no product that matches the search criteria."));
    }

    /**
     * Typing one letter in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void fieldLengthCaseOne() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("W");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Samsung SyncMaster 941BW']"));
        Assert.assertTrue(item.getText().contains("W"));
    }

    /**
     * Typing 255 letters in "Search" field.
     * @throws Exception exception
     */
    @Test
    public void fieldLengthCaseTwo() throws Exception {

        Random r = new Random();
        char[] subset = NUMBERS_AND_LETTERS.toCharArray();
        int length = 255;
        char[] buf = new char[length];
        for (int i=0;i<buf.length;i++) {
            int index = r.nextInt(subset.length);
            buf[i] = subset[index];
        }

        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        Instant start = Instant.now();;
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys(new String(buf));

        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);

        System.out.println("Execution time in seconds: " +
                interval.getSeconds());
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
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

    //65536 letters in "Search" field
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
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys(stringBuffer.toString());
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
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
