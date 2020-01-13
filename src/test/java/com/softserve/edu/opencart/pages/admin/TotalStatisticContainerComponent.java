package com.softserve.edu.opencart.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalStatisticContainerComponent {
    //TODO search selector is incorrect
    private final String STATISTIC_COMPONENT_CSSSELECTOR = ".product-layout";
    
    protected WebDriver driver;
    //
    private List<TotalStatisticComponent> statisticComponent;

    public TotalStatisticContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
        // init elements
        statisticComponent = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(STATISTIC_COMPONENT_CSSSELECTOR)))
        {
            statisticComponent.add(new TotalStatisticComponent(current));
        }
    }
}
