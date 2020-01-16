package com.softserve.edu.opencart.pages.user.shop.wishlist;

import java.util.ArrayList;
import java.util.List;
import com.softserve.edu.opencart.data.IProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListTableContainerComponent {

    protected WebDriver driver;
    private final String PRODUCT_TABLE_COMPONENT_CSS_SELECTOR = "//div[@class='table-responsive']//tbody//tr";

    private List<WishListTableComponent> wishListTableComponents; //composition

    public WishListTableContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        wishListTableComponents = new ArrayList<>();
        //finds all table products and adds to table container
        for (WebElement current : driver.findElements(By.xpath(PRODUCT_TABLE_COMPONENT_CSS_SELECTOR))) {
            wishListTableComponents.add(new WishListTableComponent(current));
        }
    }
    // Page Object

    // wishListTableComponents
    public List<WishListTableComponent> getWishListTableComponents() {
        return wishListTableComponents;
    }


    // Functional

    //get count of table elements
    public int getWishListTableComponentsCount() {
        return getWishListTableComponents().size();
    }

    //get all names from table
    public List<String> getWishListTableComponentNames() {
        List<String> wishListTableComponentNames = new ArrayList<>();
        for (WishListTableComponent current : getWishListTableComponents()) {
            wishListTableComponentNames.add(current.getNameText());
        }
        return wishListTableComponentNames;
    }

    //get table component by name
    protected WishListTableComponent getWishListTableComponentByName(IProduct productName) {
        WishListTableComponent result = null;
        for (WishListTableComponent current : getWishListTableComponents()) {
            if (current.getNameText().toLowerCase()
                    .equals(productName.getName().toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ProductName: " + productName + " not Found.");
        }
        return result;
    }

    public String getWishListTableComponentPriceByName(IProduct productName)
    {
        return getWishListTableComponentByName(productName).getUnitPriceText();
    }

    public String getWishListTableComponentModelByName(IProduct productName) {
        return getWishListTableComponentByName(productName).getModelText();
    }

    public void clickWishListTableComponentAddToCartButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickAddToCartButton();
    }
    public void clickWishListTableComponentRemoveButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickRemoveFromWishListButton();
    }

    public void clickWishListTableComponentOnName(IProduct productName) {
        getWishListTableComponentByName(productName).clickProductName();
    }

}
