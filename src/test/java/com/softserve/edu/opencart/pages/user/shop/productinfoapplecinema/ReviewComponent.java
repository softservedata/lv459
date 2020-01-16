package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewComponent extends ProductInfoAppleCinemaPage {


    private WebElement Review;

    public ReviewComponent(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        Review = driver.findElement(By.xpath("//form[@id='form-review']"));
    }

    //Page Object


    public WebElement getReview() {
        return Review;
    }

}
