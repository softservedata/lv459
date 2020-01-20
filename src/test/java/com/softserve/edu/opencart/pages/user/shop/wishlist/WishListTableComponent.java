package com.softserve.edu.opencart.pages.user.shop.wishlist;

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

    /**
     * This method inits all elements which product in wish list has.
     */
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

    /**
     * This method gets tableLayout.
     */
    public WebElement getTableLayout() {
        return tableLayout;
    }

    /**
     * This method gets image.
     */
    public WebElement getImage() {
        return image;
    }

    /**
     * This method gets productName.
     */
    public WebElement getProductName() {
        return productName;
    }

    /**
     * This method gets getNameText.
     */
    public String getNameText() {
        return getProductName().getText();
    }

    /**
     * This method clicks on prodict name
     */
    public void clickProductName() {
        getProductName().click();
    }

    /**
     * This method gets product model.
     */
    public WebElement getModel() {
        return model;
    }

    /**
     * This method gets product model text.
     */
    public String getModelText() {
        return getModel().getText();
    }

    /**
     * This method gets product stock.
     */
    public WebElement getStock() {
        return stock;
    }

    /**
     * This method gets product stock text.
     */
    public String getStockText() {
        return getStock().getText();
    }

    /**
     * This method gets product unit price.
     */
    public WebElement getUnitPrice() {
        return unitPrice;
    }

    /**
     * This method gets product unit price text.
     */
    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }

    /**
     * This method gets add to cart button.
     */
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    /**
     * This method clicks add to cart button.
     */
    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    /**
     * This method gets remove button.
     */
    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }

    /**
     * This method clicks remove button.
     */
    public void clickRemoveFromWishListButton() {
        getRemoveFromWishListButton().click();
    }
}