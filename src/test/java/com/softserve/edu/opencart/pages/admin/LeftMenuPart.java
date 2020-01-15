package com.softserve.edu.opencart.pages.admin;

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

    protected DropDownComponent dropDownCustomer;

    public LeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        if (driver.findElements(By.cssSelector(("nav#column-left.active")))
                .isEmpty()) {
            driver.findElement(By.cssSelector(("#button-menu"))).click();
        }

        customers = driver.findElement(By.id("menu-customer"));

        // TODO later add other li
        //        WebElement objElement = driver.findElement(By.cssSelector
        //
        // ("tagType[attributeName1=attributeValue1][attributeName2
        // =attributeValue2][attribute3Name=attributeValue3]"));

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
