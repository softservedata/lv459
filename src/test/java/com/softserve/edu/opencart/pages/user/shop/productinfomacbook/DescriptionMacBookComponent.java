package com.softserve.edu.opencart.pages.user.shop.productinfomacbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DescriptionMacBookComponent{

    protected WebDriver driver;
    private WebElement descriptionTab;
    private WebElement descriptionContains;

    public DescriptionMacBookComponent(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements(){

        descriptionTab = driver.findElement(By.xpath("//a[@href='#tab-description']"));
        descriptionContains = driver.findElement(By.xpath("//div[@class='tab-content']"));
    }

    //Page Object


    public WebElement getDescriptionTab(){
        return descriptionTab;
    }

    public void clickDescriptionTab(){
        getDescriptionTab().click();
    }


    public WebElement getDescriptionContains(){
        return descriptionContains;
    }

    public String getDescriptionContainsText(){
        return getDescriptionContains().getText();
    }

}
