package com.softserve.edu.opencart.pages.user.shop.productinfomacbook;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoMacBookPage extends BreadCrumbPart {

    private WebElement productName;
    private WebElement productPrice;
    private WebElement quantityLabel;
    private WebElement quantityField;
    private WebElement addToCartButton;
    private DescriptionMacBookComponent descriptionMacBookComponent;
    private SpecificationMacBookComponent specificationMacBookComponent;
    private ReviewMacBookComponent reviewMacBookComponent;


    public ProductInfoMacBookPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        productName = driver.findElement(By.cssSelector("h1"));
        productPrice = driver.findElement(By.cssSelector(".col-sm-4 h2"));
        quantityLabel = driver.findElement(By.cssSelector("#product .control-label"));
        quantityField = driver.findElement(By.cssSelector("#input-quantity"));
        addToCartButton = driver.findElement(By.cssSelector("#button-cart"));
    }


}
