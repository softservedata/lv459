package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BurgerMenuComponent {

    protected WebDriver driver;

    public BurgerMenuComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements

        if (driver.findElements(By.cssSelector(("nav#column-left.active"))).isEmpty()) {
            driver.findElement(By.cssSelector(("#button-menu"))).click();
        }

        // TODO add li and dropdowns
//        WebElement objElement = driver.findElement(By.cssSelector
//        ("tagType[attributeName1=attributeValue1][attributeName2=attributeValue2][attribute3Name=attributeValue3]"));
    }
}
