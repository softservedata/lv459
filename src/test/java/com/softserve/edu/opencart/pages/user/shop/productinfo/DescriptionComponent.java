package com.softserve.edu.opencart.pages.user.shop.productinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DescriptionComponent {

    private WebElement productLayout;
    private WebElement Description;

    public DescriptionComponent(WebElement productLayout){
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements(){

        Description = productLayout.findElement(By.xpath("//div[@id='content']//div[@class='col-sm-8']"));
    }

    //Page Object


    // get ProductLayout
    public WebElement getProductLayout() {

        return productLayout;
    }

    public WebElement getDescription(){
        return Description;
    }

    public String getDescriptionText(){
        return getDescription().getText();
    }
}
