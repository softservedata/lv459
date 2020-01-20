package com.softserve.edu.opencart.pages.user.shop.productinfomacbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.MacBookInfo;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage;

public class MacBookPage extends BreadCrumbPart {

    private WebElement productName;
    private WebElement productPrice;
    private WebElement quantityLabel;
    private WebElement quantityField;
    private WebElement addToCartButton;
    private DescriptionMacBookComponent descriptionMacBookComponent;
    private SpecificationMacBookComponent specificationMacBookComponent;
    private ReviewMacBookComponent reviewMacBookComponent;


    public MacBookPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        productName = driver.findElement(By.cssSelector("h1"));
        productPrice = driver.findElement(By.cssSelector(".col-sm-4 h2"));
        quantityLabel = driver.findElement(By.cssSelector("#product .control-label"));
        quantityField = driver.findElement(By.cssSelector("#input-quantity"));
        addToCartButton = driver.findElement(By.cssSelector("#button-cart"));
        descriptionMacBookComponent = new DescriptionMacBookComponent(driver);
        specificationMacBookComponent = new SpecificationMacBookComponent(driver);
        reviewMacBookComponent = new ReviewMacBookComponent(driver);
    }


    public WebElement getProductName(){
        return productName;
    }

    public String getProductNameText(){
        return getProductName().getText();
    }

    public WebElement getProductPrice(){
        return productPrice;
    }

    public String getProductPriceText(){
        return getProductPrice().getText();
    }

    public WebElement getQuantityLabel(){
        return quantityLabel;
    }

    public String getQuantityLabelText(){
        return getQuantityLabel().getText();
    }

    public WebElement getQuantityField(){
        return quantityField;
    }

    public void clickQuantityField(){
        getQuantityField().click();
    }

    public void clearQuantityField(){
        getQuantityField().clear();
    }


    public void setQuantityField(String qty){
        getQuantityField().sendKeys(qty);
    }


    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    public void clickAddToCartButton(){
        getAddToCartButton().click();
    }

    public DescriptionMacBookComponent getDescriptionMacBookComponent(){
        return descriptionMacBookComponent;
    }

    public SpecificationMacBookComponent getSpecificationMacBookComponent(){
        return specificationMacBookComponent;
    }

    public ReviewMacBookComponent getReviewMacBookComponent(){
        return reviewMacBookComponent;
    }

    //Functional

    public void setQuantity(MacBookInfo qty){
        clickQuantityField();
        clearQuantityField();
        getQuantityField().sendKeys( qty.getQuantity());  //// Idk how correct is that.
    }

    //Business Logic

    public AlertMessagePage addMacBookToCartWithQty(MacBookInfo qty){
        setQuantity(qty);
        clickAddToCartButton();
        return new AlertMessagePage(driver);
    }


}
