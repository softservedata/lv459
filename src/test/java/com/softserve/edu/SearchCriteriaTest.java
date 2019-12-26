/**
 * Package for testing OpenCart website.
 */
package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchCriteriaTest extends LocalTestRunner {

    /**
     * Typing in "Search Criteria" field value "Samsung SyncMaster 941BW"
     * checking if there is this word in the description and
     * checking subcategory if there is "Samsung SyncMaster 941BW".
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseOne() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        //
        // Typing in the "Search Criteria" field
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).
                sendKeys("Samsung SyncMaster 941BW");
        //
        // Clicking on the "Category" drop-down list
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        // Choosing from the "Category" drop-down list
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).
                sendKeys("Components" + Keys.ENTER);
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking that the is no "Samsung SyncMaster 941BW"
        // in category "Components"
        WebElement notFound = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(notFound.getText().
                contains("There is no product"
                        + " that matches the search criteria."));
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        //Clicking on the "Search in subcategories" checkbox
        driver.findElement(By.xpath(SEARCH_IN_SUBCATEGORIES_CHECKBOX)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        //Clicking on the "Search in product descriptions" checkbox
        driver.findElement(By.xpath(
                SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement samsung = driver.findElement(By.
                xpath("//a[text()='Samsung SyncMaster 941BW']"));
        Assert.assertTrue(samsung.getText().
                contains("Samsung SyncMaster 941BW"));

        //
        // Clicking on item
        driver.findElement(By.
                xpath("//a[text()='Samsung SyncMaster 941BW']")).click();
        // Checking description if it contains "Samsung SyncMaster 941BW"
        WebElement description = driver.findElement(By.
                xpath("//h1[contains(text(), 'Samsung SyncMaster 941BW')]"));
        Assert.assertTrue(description.getText().
                contains("Samsung SyncMaster 941BW"));
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Clicking "Components" tab on the navigation bar
        driver.findElement(By.
                xpath(COMPONENTS_TAB_ON_THE_NAVIGATION_BAR)).click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        // Clicking "Show All Components" on the drop-down menu
        driver.findElement(By.
                xpath("//nav[@id='menu']//div[@class='dropdown-inner']/"
                        + "following-sibling::a[contains(text(),"
                        + " 'Show All Components')]")).click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        // Checking if there is "Monitors" in the "Components" category
        WebElement item = driver.findElement(By.xpath("//div[@class='col-sm-3']"
                + "//a[contains(text(), 'Monitors')]"));
        Assert.assertTrue(item.getText().contains("Monitors"));
        // Clicking on "Monitors"
        driver.findElement(By.xpath("//div[@class='col-sm-3']"
                + "//a[contains(text(), 'Monitors')]")).click();
        // Checking if there is "Samsung SyncMaster 941BW"
        // in the "Components" subcategory
        WebElement subcategory = driver.findElement(By.
                xpath("//a[text()='Samsung SyncMaster 941BW']"));
        Assert.assertTrue(subcategory.getText().
                contains("Samsung SyncMaster 941BW"));
        Thread.sleep(THREE_SECONDS); // For Presentation Only
    }

    /**
     * Typing in "Search Criteria" field value "apple"
     * checking if there is this word in the description in other
     * products, checking categories and subcategory.
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseTwo() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Typing in the "Search Criteria" field
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).sendKeys("apple");
        //
        // Clicking on the "Category" drop-down list
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Choosing from the "Category" drop-down list
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).
                sendKeys("All Categories" + Keys.ENTER);
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        //
        //Clicking on the "Search in product descriptions" checkbox
        driver.findElement(By.
                xpath(SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX)).click();
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement apple = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
        //
        // Checking
        WebElement mac = driver.findElement(By.
                xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(mac.getText().contains("MacBook Pro"));
        //
        // Clicking on item
        driver.findElement(By.xpath("//a[text()='MacBook Pro']")).click();
        // Checking if it has word "Apple"
        WebElement paragraph = driver.findElement(By.
                xpath("//p[contains(text(), 'Apple')]"));
        Assert.assertTrue(paragraph.getText().contains("Apple"));
        Thread.sleep(FOUR_SECONDS); // For Presentation Only
        //
        // Clicking "Components" tab on the navigation bar
        driver.findElement(By.
                xpath(COMPONENTS_TAB_ON_THE_NAVIGATION_BAR)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        // Clicking "Monitors" on the drop-down menu
        driver.findElement(By.xpath("//nav[@id='menu']"
                + "//div[@class='dropdown-inner']"
                + "//a[contains(text(), 'Monitors')]")).click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        //
        // Clicking if there is "Apple Cinema 30" in "Monitors" subcategory
        WebElement applecinema = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(applecinema.getText().contains("Apple Cinema 30\""));
        //
        // Clicking if there is "MacBook Pro" in "Laptops & Notebooks" category
        driver.findElement(By.xpath("//nav[@id='menu']//"
                + "li[@class='dropdown']"
                + "/a[contains(.,'Laptops & Notebooks')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']"
                + "//div[@class='dropdown-inner']/following-sibling::a"
                + "[contains(text(), 'Show All Laptops & Notebooks')]"))
                .click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        // Checking
        WebElement macbook = driver.findElement(By.
                xpath("//a[text()='MacBook Pro']"));
        Assert.assertTrue(macbook.getText().contains("MacBook Pro"));
    }

    /**
     * Typing in "Search Criteria" field value "HP LP3065"
     * checking if there is this word in the description in other
     * products, checking categories.
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseThree() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).sendKeys("HP LP3065");
        //
        // Clicking if there is "HP LP3065" in "Laptops & Notebooks" category
        driver.findElement(By.xpath("//nav[@id='menu']//"
                + "li[@class='dropdown']"
                + "/a[contains(.,'Laptops & Notebooks')]")).click();
        driver.findElement(By.xpath("//nav[@id='menu']"
                + "//div[@class='dropdown-inner']/following-sibling::a"
                + "[contains(text(), 'Show All Laptops & Notebooks')]"))
                .click();
        Thread.sleep(THREE_SECONDS); // For Presentation Only
        WebElement macbook = driver.findElement(By.
                xpath("//a[text()='HP LP3065']"));
        Assert.assertTrue(macbook.getText().contains("HP LP3065"));
        //Clicking on the "Search in product descriptions" checkbox
        driver.findElement(By.xpath(
                SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
        //
        // Checking
        WebElement samsung = driver.findElement(By.
                xpath("//a[text()='HP LP3065']"));
        Assert.assertTrue(samsung.getText().
                contains("HP LP3065"));

        //
        // Clicking on item
        driver.findElement(By.
                xpath("//a[text()='HP LP3065']")).click();
        // Checking description if it contains "HP LP3065"
        WebElement description = driver.findElement(By.
                xpath("//h1[contains(text(), 'HP LP3065')]"));
        Assert.assertTrue(description.getText().
                contains("HP LP3065"));
        Thread.sleep(TWO_SECONDS); // For Presentation Only
    }

    /**
     * Typing in "Search Criteria" field value "Samsung SyncMaster 941BW"
     * checking if there is this word in the description and
     * checking subcategory if there is "Samsung SyncMaster 941BW".
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseFive() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).
                sendKeys("Apple Cinema 30\"");
        //
        // Clicking on the "Category" select
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).click();
        // Choosing from the "Category" drop-down list
        driver.findElement(By.name(CATEGORY_DROP_DOWN_LIST)).
                sendKeys("Monitors" + Keys.ENTER);
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();

        //
        // Checking
        WebElement item = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(item.getText().contains("Apple Cinema 30\""));
        //
        // Clicking "Components" tab on the navigation bar
        driver.findElement(By.
                xpath(COMPONENTS_TAB_ON_THE_NAVIGATION_BAR)).click();
        driver.findElement(By.xpath("//nav[@id='menu']"
                + "//div[@class='dropdown-inner']"
                + "//a[contains(text(), 'Monitors')]")).click();
        // Checking
        WebElement apple = driver.findElement(By.
                xpath("//a[text()='Apple Cinema 30\"']"));
        Assert.assertTrue(apple.getText().contains("Apple Cinema 30\""));
    }

    /**
     * Typing in "Search Criteria" field value "Samsung Galaxy Tab 10.1"
     * checking if there is this word in the description.
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseSix() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).
                sendKeys("Samsung Galaxy Tab 10.1");
        //
        // Clicking on the "Search in product descriptions" checkbox
        driver.findElement(By.cssSelector("#content > p > label")).click();
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        //
        // Checking
        WebElement samsung = driver.findElement(By.
                xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(samsung.getText().
                contains("Samsung Galaxy Tab 10.1"));
        // Checking if there is "Samsung Galaxy Tab 10.1" in the description
        driver.findElement(By.
                xpath("//a[text()='Samsung Galaxy Tab 10.1']")).click();
        WebElement header = driver.findElement(By.
                xpath("//div[@class='col-sm-4']//h1"));
        WebElement samsungText = driver.findElement(By.
                cssSelector("#tab-description p:first-child"));
        Assert.assertTrue(samsungText.getText().contains(header.getText()));
    }

    /**
     * Typing in "Search Criteria" field value "Samsung Galaxy Tab 10.1"
     * checking if there is this item.
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseSeven() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).
                sendKeys("Samsung Galaxy Tab 10.1");
        //
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        //
        // Checking
        WebElement samsung = driver.findElement(By.
                xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
        Assert.assertTrue(samsung.getText().
                contains("Samsung Galaxy Tab 10.1"));
    }

    /**
     * Empty "Search Criteria" field.
     *
     * @throws Exception exception
     */
    @Test
    public void searchCriteriaCaseEight() throws Exception {
        // Steps
        // Typing in the "Search" field
        driver.findElement(By.name(SEARCH_FIELD)).click();
        driver.findElement(By.name(SEARCH_FIELD)).clear();
        driver.findElement(By.name(SEARCH_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        //
        // Typing in the "Search" field in "Criteria" window
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).click();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).clear();
        driver.findElement(By.id(SEARCH_CRITERIA_FIELD)).sendKeys("");
        //
        // Clicking on the "Search" button
        driver.findElement(By.id(SEARCH_CRITERIA_BUTTON)).click();
        //
        // Checking
        WebElement zeroLength = driver.findElement(By.
                xpath("//input[@id='button-search']/following-sibling::p"));
        Assert.assertTrue(zeroLength.getText().contains(
                "There is no product that matches the search criteria."));
    }

}
