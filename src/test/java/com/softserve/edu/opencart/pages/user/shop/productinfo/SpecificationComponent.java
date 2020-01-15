package com.softserve.edu.opencart.pages.user.shop.productinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecificationComponent {

    private WebElement productLayout;
    private WebElement Specification;

    public SpecificationComponent(WebElement productLayout){
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements(){

        Specification = productLayout.findElement(By.xpath("//div[@id='tab-specification']"));
    }

    //Page Object


    // get ProductLayout
    public WebElement getProductLayout() {

        return productLayout;
    }

    public WebElement getSpecification(){
        return Specification;
    }

}
