package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownCustomers {

    private WebDriver driver;

    private WebElement parent;
    private WebElement customersCustomers;
    private WebElement customersCustomerGroups;
    private WebElement customersCustomerFields;

    protected DropDownCustomers(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        customersCustomers = driver.findElement(By.xpath(
                "//li[@id='menu-customer'][@class='open']//a[contains (@href," +
                "'customer/customer&')]"));
        //        customersCustomerGroups
        //        customersCustomerFields
    }

    // MenuGroup Customers --- BEGIN ---

    public WebElement getCustomersCustomers() {
        return customersCustomers;
    }

    public String getCustomersCustomersText() {
        return customersCustomers.getText();
    }

    public void clickCustomersCustomers() {
        customersCustomers.click();
    }

    // MenuGroup Customers --- FINISH ---
}
