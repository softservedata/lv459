package com.softserve.edu.opencart.pages.user.shop.productinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewComponent {

    private WebElement productLayout;
    private WebElement Review;

    public ReviewComponent(WebElement productLayout){
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements(){

        Review = productLayout.findElement(By.xpath("//form[@id='form-review']"));
    }

    //Page Object


    // get ProductLayout
    public WebElement getProductLayout() {

        return productLayout;
    }

    public WebElement getReview() {
        return Review;
    }

}
