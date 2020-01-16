package com.softserve.edu.opencart.pages.user.shop.productinfomacbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewMacBookComponent {

    protected WebDriver driver;

    private WebElement reviewTab;
    private WebElement reviewContains;

    public ReviewMacBookComponent(WebDriver driver) {
        this.driver = driver;
    }

    private void initElements(){

        reviewTab = driver.findElement(By.xpath("//a[@href='#tab-review']"));
        reviewContains = driver.findElement(By.cssSelector("#tab-review"));
    }

    public WebElement getReviewTab(){
        return reviewTab;
    }

    public void clickReviewTab(){
        getReviewTab().click();
    }

    public WebElement getReviewContains(){
        return reviewContains;
    }
}
