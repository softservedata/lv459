package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoContainerComponent {

    private final String PRODUCT_CONTAINER_COMPONENT = "#product";

    protected WebDriver driver;

    private List<ProductInfoComponents> productInfoComponents;

    public ProductInfoContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        productInfoComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_CONTAINER_COMPONENT))){
            productInfoComponents.add(new ProductInfoComponents(current));
        }
    }

    //Page Object

    public List<ProductInfoComponents> getProductInfoComponents(){
        return productInfoComponents;
    }

    //Functional

    // Product Info Components Size
    public int getProductInfoComponentsCount(){
        return getProductInfoComponents().size();
    }


    //Business Logic
}
