package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponCartComponent {

    //private WebElement productLayout;
    private WebElement Coupon;

///????????????????????????????????????????????????????????
    protected WebDriver driver;  // What I should to use (driver or productLayout)

    public CouponCartComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        Coupon = driver.findElement(By.xpath("//a[contains(text(),'Use Coupon')]/../../.."));
    }

    //Page Object

    /*public WebElement getProductLayout() {
        return productLayout;
    }*/

    public WebElement getCoupon(){
        return Coupon;
    }

    //Functional

    //Business logic
}
