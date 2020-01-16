package com.softserve.edu.opencart.pages.user.shop.productinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DescriptionComponent extends ProductInfoAppleCinemaPage {

    private WebElement Description;

    public DescriptionComponent(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        Description = driver.findElement(By.xpath("//div[@id='content']//div[@class='col-sm-8']"));
    }

    //Page Object


    public WebElement getDescription(){
        return Description;
    }

    public String getDescriptionText(){
        return getDescription().getText();
    }
}
