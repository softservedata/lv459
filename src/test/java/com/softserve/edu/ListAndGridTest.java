/**
 * Package for testing OpenCart website.
 */
package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ListAndGridTest extends LocalTestRunner {

    /**
     * Pressing "Grid" button on "Search" window
     * in "Search" field.
     *
     * @throws Exception exception
     */
    @Test
    public void caseOne() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_BUTTON)).click();
        driver.findElement(By.name(SEARCH_BUTTON)).clear();
        driver.findElement(By.name(SEARCH_BUTTON)).sendKeys("iPhone");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        // Clicking on the "Grid" button
        driver.findElement(By.id("grid-view")).click();
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        Assert.assertTrue(driver.findElement(By.id("grid-view")).
                getAttribute("class").equals("btn btn-default active"));
    }

    /**
     * Pressing "List" button on "Search" window
     * in "Search" field.
     *
     * @throws Exception exception
     */
    @Test
    public void caseTwo() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_BUTTON)).click();
        driver.findElement(By.name(SEARCH_BUTTON)).clear();
        driver.findElement(By.name(SEARCH_BUTTON)).sendKeys("iPhone");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Clicking on the "Grid" button
        driver.findElement(By.id("list-view")).click();
        Assert.assertTrue(driver.findElement(By.id("list-view")).
                getAttribute("class").equals("btn btn-default active"));
        Thread.sleep(TWO_SECONDS); // For Presentation Only
    }

}
