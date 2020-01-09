package com.softserve.edu.opencart.pages.user.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListMessagePage extends WishListPage {


    public static final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
    public static final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!"; //витягувати від імені класу


    public WishListMessagePage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
    }

    //page object

    //functional
    //get message

    //BL
    //click on хрестик
}
