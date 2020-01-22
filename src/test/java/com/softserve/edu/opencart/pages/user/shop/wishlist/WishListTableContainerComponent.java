package com.softserve.edu.opencart.pages.user.shop.wishlist;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IProduct;

/**
 *  Wish List Table Container Component class.
 */
public class WishListTableContainerComponent {

    protected WebDriver driver;
    private final String PRODUCT_TABLE_COMPONENT_CSS_SELECTOR = "//div[@class='table-responsive']//tbody//tr";

    private List<WishListTableComponent> wishListTableComponents; //composition

    public WishListTableContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * This method inits elements.
     */
    private void initElements() {
        // init elements
        wishListTableComponents = new ArrayList<>();
        //finds all table products and adds to table container
        for (WebElement current : driver.findElements(By.xpath(PRODUCT_TABLE_COMPONENT_CSS_SELECTOR))) {
            wishListTableComponents.add(new WishListTableComponent(current));
        }
    }
    // Page Object

    /**
     * This method gets wishListTableComponents.
     */
    public List<WishListTableComponent> getWishListTableComponents() {
        return wishListTableComponents;
    }


    // Functional

    /**
     * This method gets count of table elements.
     */
    public int getWishListTableComponentsCount() {
        return getWishListTableComponents().size();
    }

    /**
     * This method gets all names from table.
     */
    public List<String> getWishListTableComponentNames() {
        List<String> wishListTableComponentNames = new ArrayList<>();
        for (WishListTableComponent current : getWishListTableComponents()) {
            wishListTableComponentNames.add(current.getNameText());
        }
        return wishListTableComponentNames;
    }

    /**
     * This method gets table component by name.
     */
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
            throw new RuntimeException("ProductName: " + productName + " not Found.");
        }
        return result;
    }

    /**
     * This method gets table component price by name.
     */
    public String getWishListTableComponentPriceByName(IProduct productName) {
        return getWishListTableComponentByName(productName).getUnitPriceText();
    }

    /**
     * This method gets table component model by name.
     */
    public String getWishListTableComponentModelByName(IProduct productName) {
        return getWishListTableComponentByName(productName).getModelText();
    }

    /**
     * This method clicks table component add to cart button by name.
     */
    public void clickWishListTableComponentAddToCartButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickAddToCartButton();
    }

    /**
     * This method clicks table component remove button by name.
     */
    public void clickWishListTableComponentRemoveButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickRemoveFromWishListButton();
    }

    /**
     * This method clicks table component on name.
     */
    public void clickWishListTableComponentOnName(IProduct productName) {
        getWishListTableComponentByName(productName).clickProductName();
    }

}
