package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends LeftMenuPart {

    // private LeftMenuPart burgerMenuComponent;

    private WebElement homePageContent;
    private TotalStatisticContainerComponent totalStatisticContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        homePageContent = driver.findElement(By.cssSelector("#content>.container-fluid"));
        totalStatisticContainer = new TotalStatisticContainerComponent(driver);
    }

    // Page Object
    
    public TotalStatisticContainerComponent getTotalStatisticContainer() {
        return totalStatisticContainer;
    }

    // Functional

    // Business Logic

    public CustomersPage gotoCustomersCustomersPage() {
        clickCustomers();
        DropDownCustomers dropDownCustomers = new DropDownCustomers(driver);
        dropDownCustomers.clickCustomersCustomers();
        return new CustomersPage(driver);
    }
}
