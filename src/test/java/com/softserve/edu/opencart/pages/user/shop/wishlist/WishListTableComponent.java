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
     * <h3>This method inits all elements which product in wish list has.</h3>
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
     * <h3>This method gets tableLayout.</h3>
     */
    public WebElement getTableLayout() {
        return tableLayout;
    }

    /**
     * <h3>This method gets image.</h3>
     */
    public WebElement getImage() {
        return image;
    }

    /**
     * <h3>This method gets productName.</h3>
     */
    public WebElement getProductName() {
        return productName;
    }

    /**
     * <h3>This method gets getNameText.</h3>
     */
    public String getNameText() {
        return getProductName().getText();
    }

    /**
     * <h3>This method clicks on prodict name</h3>
     */
    public void clickProductName() {
        getProductName().click();
    }

    /**
     * <h3>This method gets product model.</h3>
     */
    public WebElement getModel() {
        return model;
    }

    /**
     * <h3>This method gets product model text.</h3>
     */
    public String getModelText() {
        return getModel().getText();
    }

    /**
     * <h3>This method gets product stock.</h3>
     */
    public WebElement getStock() {
        return stock;
    }

    /**
     * <h3>This method gets product stock text.</h3>
     */
    public String getStockText() {
        return getStock().getText();
    }

    //TODO
    //there is sometimes two price what to do?
    // unitPrice
    //по регулярному виразу витягувати першу ціну
    /**
     * <h3>This method gets product unit price.</h3>
     */
    public WebElement getUnitPrice() {
        return unitPrice;
    }

    /**
     * <h3>This method gets product unit price text.</h3>
     */
    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }

    /**
     * <h3>This method gets add to cart button.</h3>
     */
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    /**
     * <h3>This method clicks add to cart button.</h3>
     */
    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    /**
     * <h3>This method gets remove button.</h3>
     */
    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }

    /**
     * <h3>This method clicks remove button.</h3>
     */
    public void clickRemoveFromWishListButton() {
        getRemoveFromWishListButton().click();
    }
}