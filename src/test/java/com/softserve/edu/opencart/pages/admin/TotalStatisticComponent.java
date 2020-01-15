package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TotalStatisticComponent {
    private WebElement statisticLayout;
    private WebElement statisticName;
    private WebElement statisticDetail;
    
    public TotalStatisticComponent(WebElement statisticLayout) {
        this.statisticLayout = statisticLayout;
        initElements();
    }
    private void initElements() {
        statisticName = statisticLayout.findElement(By.cssSelector(".tile-heading"));
        statisticDetail = statisticLayout.findElement(By.cssSelector(".tile-footer a"));
    }

    // Page Object

    // firstNameField
  

    // Functional

    // Business Logic
}
