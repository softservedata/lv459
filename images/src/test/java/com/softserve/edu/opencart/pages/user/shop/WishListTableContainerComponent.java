package com.softserve.edu.opencart.pages.user.shop;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListTableContainerComponent {

    //where they are supposed to be?
    public final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
    public final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

    private final String PRODUCT_TABLE_COMPONENT_CSS_SELECTOR = "//div[@class='table-responsive']//tbody//tr";
    protected WebDriver driver;

    private List<WishListTableComponent> wishListTableComponents; //aggregation

    public WishListTableContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        wishListTableComponents = new ArrayList<>();
        //find all table products and add to container
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_TABLE_COMPONENT_CSS_SELECTOR))) {
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

    //Get all names from table
    public List<String> getWishListTableComponentNames() {
        List<String> wishListTableComponentNames = new ArrayList<>();
        for (WishListTableComponent current : getWishListTableComponents()) {
            wishListTableComponentNames.add(current.getNameText());
        }
        return wishListTableComponentNames;
    }


    //Get table component by name
    protected WishListTableComponent getWishListTableComponentByName(String productName) {
        WishListTableComponent result = null;
        for (WishListTableComponent current : getWishListTableComponents()) {
            if (current.getNameText().toLowerCase()
                    .equals(productName.toLowerCase())) {
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

    // TODO Change to Product
    public String getWishListTableComponentPriceByName(String productName)
    {
        return getWishListTableComponentByName(productName).getUnitPriceText();
    }

   // TODO Change to Product
    public String getWishListTableComponentModelByName(String productName) {
        return getWishListTableComponentByName(productName).getModelText();
    }

    // TODO Change to Product
    public void clickWishListTableComponentAddToCartButtonByName(String productName) {
        getWishListTableComponentByName(productName).clickAddToCartButton();
    }




//    public String getProductComponentPriceByProduct(Product product)
//    {
//        return getProductComponentPriceByName(product.getName());
//    }
//
//    public String getProductComponentDescriptionByProduct(Product product)
//    {
//        return getProductComponentDescriptionByName(product.getName());
//    }
//
//
        // Business Logic
//    public WishListTableComponent getProductComponentByName(Product product)
//    {
//        return getProductComponentByName(product.getName());
//    }

}
