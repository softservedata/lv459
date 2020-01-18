package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LeftMenuPart extends TopMenuPart {

    protected WebElement profile;
    protected WebElement catalog;
    protected WebElement extensions;
    protected WebElement design;
    protected WebElement sales;
    protected WebElement customers;
    protected WebElement marketing;
    protected WebElement system;
    protected WebElement reports;
    protected WebElement stats;
    protected WebElement header;
    protected WebElement footer;

    protected DropDownComponent dropDownCustomer;

    public LeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        header = driver.findElement(By.cssSelector(".page-header"));
        footer = driver.findElement(By.id("footer"));

        if (driver.findElement(By.cssSelector(("nav#column-left"))).getAttribute("class").isEmpty()) {
            //Expand 'burger menu'
            driver.findElement(By.cssSelector(("#button-menu"))).click();
        }

        catalog = driver.findElement(By.id("menu-catalog"));
        extensions = driver.findElement(By.id("menu-extension"));
        design = driver.findElement(By.id("menu-design"));
        sales = driver.findElement(By.id("menu-sale"));
        customers = driver.findElement(By.id("menu-customer"));
        marketing = driver.findElement(By.id("menu-catalog"));
        system = driver.findElement(By.id("menu-marketing"));
        reports = driver.findElement(By.id("menu-report"));
        stats = driver.findElement(By.id("stats"));

    }

    public void clickCatalog() {
        catalog.click();
    }
    
    public void clickCustomers() {
        customers.click();
    }

    public String getCustomersText() {
        return customers.getText();
    }

    public WebElement getCustomers() {
        return customers;
    }

}
