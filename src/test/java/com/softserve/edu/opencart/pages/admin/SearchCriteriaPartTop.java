package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SearchCriteriaPartTop extends MenuPart{
    
    private WebElement criteriaSearchButton;

    public SearchCriteriaPartTop(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements() {
        criteriaSearchButton.findElement(By.id("button-filter"));
    }

    // Page Object

    // firstNameField
  

    // Functional

    // Business Logic
}
