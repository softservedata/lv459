package com.softserve.edu.opencart.pages.user.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class WishListTableComponent {

    private WebElement tableLayout;
    private WebElement image;
    private WebElement productName;
    private WebElement model;
    private WebElement stock;
    private WebElement unitPrice;
    private WebElement addToCartButton;
    private WebElement removeFromWishListButton;

    public  WishListTableComponent(WebElement tableLayout) {
        this.tableLayout = tableLayout;
        initElements();
    }

    private void initElements() {
        // init elements
        image = tableLayout.findElement(By.xpath("//div[@class='table-responsive']//td[@class='text-center']/a"));
        productName = tableLayout.findElement(By.xpath("//div[@class='table-responsive']//td[@class='text-left']/a"));
        model = tableLayout.findElement(By.xpath("//tbody//td[contains(text(),'roduct')]"));
        stock = tableLayout.findElement(By.xpath("//tbody//td[contains(text(),'Stock')]"));
        unitPrice = tableLayout.findElement(By.xpath(("//div[@class='price']")));
        addToCartButton = tableLayout.findElement(By.cssSelector("tbody .fa.fa-shopping-cart"));
        removeFromWishListButton = tableLayout.findElement(By.cssSelector(".fa.fa-times"));

    }
    // Page Object

    // tableProduct
    public WebElement getTableLayout() {
        return tableLayout;
    }

    // image
    public WebElement getImage() {
        return image;
        //return productLayout.findElement(By.cssSelector("h4 a"));
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

    //TODO
    //there is sometimes two price what to do?
    // unitPrice
    //по регулярному виразу витягувати першу ціну
    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }

    // addToCartButton
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    //Click add to cart
    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    // Remove FromWishListButton
    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }

    public void clickRemoveFromWishListButton() {
        getRemoveFromWishListButton().click();
    }

    // Functional

    //дай першу ціну витягнути текст Обєкт класу рег вирази дьорнути метод віддай рез 1 -2 стрічки decimal

    // Business Logic
}