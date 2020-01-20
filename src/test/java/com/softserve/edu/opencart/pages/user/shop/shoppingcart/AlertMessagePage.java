package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.shop.productinfomacbook.MacBookPage;

public class AlertMessagePage extends MacBookPage {

    public static final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

    private WebElement RemoveMessageButton;
    private WebElement AddToCartMessage;

    public AlertMessagePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        RemoveMessageButton = driver.findElement(By.xpath("//div[@class='alert alert-success']//button"));
        AddToCartMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
}

    // Page Object

    public WebElement getRemoveMessageButton(){
        return RemoveMessageButton;
    }

    public void clickRemoveMessageButton(){
        getRemoveMessageButton().click();
    }

    public WebElement getAddToCartMessage(){
        return AddToCartMessage;
    }

    public String getProductAddedToCartText(){
        return getAddToCartMessage().getText();
    }

    // Functional

    //Business logic
}
