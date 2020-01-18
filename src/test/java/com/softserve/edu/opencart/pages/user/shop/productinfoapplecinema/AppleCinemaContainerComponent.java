package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AppleCinemaContainerComponent {

    private final String PRODUCT_CONTAINER_COMPONENT = "#product";

    protected WebDriver driver;

    private List<AppleCinemaComponents> appleCinemaComponents;

    public AppleCinemaContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        appleCinemaComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_CONTAINER_COMPONENT))){
            appleCinemaComponents.add(new AppleCinemaComponents(current));
        }
    }

    //Page Object

    public List<AppleCinemaComponents> getProductInfoComponents(){
        return appleCinemaComponents;
    }

    //Functional








    //Business Logic
}
