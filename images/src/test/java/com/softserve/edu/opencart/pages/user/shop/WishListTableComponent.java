package com.softserve.edu.opencart.pages.user.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class WishListTableComponent {

    private WebElement tableLayout;
    //
    private WebElement image;
    private WebElement productName;
    private WebElement model;
    private WebElement stock;
    private WebElement unitPrice;
    private WebElement addToCartButton;
    private WebElement addToWishButton;
    private WebElement addToCompareButton;
    private WebElement removeFromWishListButton;

    public  WishListTableComponent(WebElement tableLayout) {
        this.tableLayout = tableLayout;
        initElements();
    }

    private void initElements() {
        // init elements
        image = tableLayout.findElement(By.));
        productName = tableLayout.findElement(By.);
        model = tableLayout.findElement(By.);
        stock = tableLayout.findElement(By.);
        unitPrice = tableLayout.findElement(By.);
        addToCartButton = tableLayout.findElement(By.);
        addToWishButton = tableLayout.findElement(By.);
        addToCompareButton = tableLayout.findElement(By.);
        removeFromWishListButton = tableLayout.findElement();

    }

    // Page Object

    // tableProduct
    public WebElement getTableLayout() {
        return tableLayout;
    }

    // name
    public WebElement getProductName() {
        return productName;
        //return productLayout.findElement(By.cssSelector("h4 a"));
    }

    public String getNameText() {
        return getProductName().getText();
    }

    public void clickProductName() {
        getProductName().click();
    }

    // model
    public WebElement getModel() {
        return model;
    }

    public String getModelText() {
        return getModel().getText();
    }

    // stock
    public WebElement getStock() {
        return stock;
    }

    public String getStockText() {
        return getStock().getText();
    }

    // unitPrice
    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }
    //TODO
    //there is sometimes two price what



    // addToCartButton

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }


    // removeFromWishListButton

    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }

    public void clickremoveFromWishListButton() {
        getRemoveFromWishListButton().click();
    }




    // Functional


    // Business Logic

}