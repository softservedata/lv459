package com.softserve.edu.opencart.pages.user.shop.productinfomacbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecificationMacBookComponent {

    protected WebDriver driver;
    private WebElement specificationTab;
    private WebElement specificationContains;

    public SpecificationMacBookComponent(WebDriver driver){
        this.driver = driver;
        initElements();
    }


    private void initElements(){
        specificationTab = driver.findElement(By.xpath("//a[@href='#tab-specification']"));
        specificationContains = driver.findElement(By.cssSelector("#tab-specification"));
    }

    //Page Object


    public WebElement getSpecificationTab(){
        return specificationTab;
    }

    public void clickSpecificationTab(){
        getSpecificationTab().click();
    }


    public WebElement getSpecificationContains(){
        return specificationContains;
    }

}
