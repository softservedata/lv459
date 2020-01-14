package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCartComponent{

   // private WebElement productLayout;
    private WebElement Gift;


    ///????????????????????????????????????????????????????????
    protected WebDriver driver;  // What I should to use (driver or productLayout)

    public GiftCartComponent(WebDriver drivert) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        Gift = driver.findElement(By.xpath("//a[contains(text(),'Use Gift')]/../../.."));
    }

    //Page Object

   /* public WebElement getProductLayout() {
        return productLayout;
    }
*/
    public WebElement getGift(){
        return Gift;
    }

    //Functional

    //Business logic
}
