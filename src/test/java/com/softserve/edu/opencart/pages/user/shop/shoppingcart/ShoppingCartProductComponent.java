package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartProductComponent {

    //Ask How todo (productLayout or driver)
    private WebElement productLayout;
    private WebElement Image;
    private WebElement Product_Name;
    private WebElement Model;
    private WebElement Quantity;
    private WebElement Refresh_Button;
    private WebElement Delete_Button;
    private WebElement Unit_Price;
    private WebElement Total_Price;


    public ShoppingCartProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements(){

        Image = productLayout.findElement(By.xpath("//div[@id='content']//a/img"));
        Product_Name = productLayout.findElement(By.xpath("//div[@id='content']//td[@class='text-left']/a"));
        Model = productLayout.findElement(By.xpath("//tbody//td[contains(text(),'roduct')]"));
        Quantity = productLayout.findElement(By.xpath("//div[@class='table-responsive']//td//input"));
        Refresh_Button = productLayout.findElement(By.xpath("//i[@class='fa fa-refresh']"));
        Delete_Button = productLayout.findElement(By.xpath("//i[@class='fa fa-times-circle']"));
        Unit_Price = productLayout.findElement(By.xpath("//div[@class='input-group btn-block']/../following-sibling::td[1]"));
        Total_Price = productLayout.findElement(By.xpath("//div[@class='input-group btn-block']/../following-sibling::td[2]"));
    }

    //Page Object


    // get ProductLayout
    public WebElement getProductLayout() {

        return productLayout;
    }

    // get image
    public WebElement getImage() {
        return Image;

    }

    // get product name
    public WebElement getProductName() {
        return Product_Name;

    }

    // product name text
    public String getProductNameText(){
        return getProductName().getText();
    }

    // get model
    public WebElement getModel() {
        return Model;
    }

    // model text
    public String getModelText(){
        return getModel().getText();
    }

    //get Quantity
    public WebElement getQuantity(){
        return Quantity;
    }

    //click to Quantity Field
    public void clickQuantityField(){
        getQuantity().click();
    }

    // clear Quantity Field
    public void clearQuantityField(){
        getQuantity().clear();
    }

    // type quantity
    public void typeQuantity(String quantity){
        getQuantity().sendKeys(quantity);
    }

    // get Refresh Button
    public WebElement getRefreshButton(){
        return Refresh_Button;
    }

    //click Refresh Button
    public void clickRefreshButton(){
        getRefreshButton().click();
    }

    //get Delete Button
    public WebElement getDeleteButton(){
        return Delete_Button;
    }

    //click Delete Button
    public void clickDeleteButton(){
        getDeleteButton().click();
    }

    // get UnitPrice
    public WebElement getUnitPrice(){
        return Unit_Price;
    }

    //get UnitPrice Text
    public String getUnitPriceText(){
        return getUnitPrice().getText();
    }

    //get Total Price
    public WebElement getTotalPrice(){
        return Total_Price;
    }

    //get Total Price Text
    public String getTotalPriceText(){
        return getTotalPrice().getText();
    }



    //Functional

    //Business logic
}
