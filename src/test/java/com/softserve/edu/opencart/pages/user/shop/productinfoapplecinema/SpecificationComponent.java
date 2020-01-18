package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecificationComponent extends AppleCinemaPage {

    private WebElement Specification;

    public SpecificationComponent(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        Specification = driver.findElement(By.xpath("//div[@id='tab-specification']"));
    }

    //Page Object



    public WebElement getSpecification(){
        return Specification;
    }

}
