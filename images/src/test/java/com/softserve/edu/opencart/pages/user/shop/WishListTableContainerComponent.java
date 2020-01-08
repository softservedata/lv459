
package com.softserve.edu.opencart.pages.user.shop;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.pages.user.shop.WishListTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.softserve.edu.opencart.data.Product;

public class WishListTableContainerComponent { //Табличка всіх табличок які додан в ВішЛіст


    //where they are supposed to be??
    public final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
    public final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

    private final String PRODUCT_TABLE_COMPONENT_CSSSELECTOR = " ";
    //
    protected WebDriver driver;
    //
    private List<WishListTableComponent> wishListTableComponents;

    public WishListTableContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        wishListTableComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_TABLE_COMPONENT_CSSSELECTOR)))
        {
            wishListTableComponents.add(new WishListTableComponent(current));
        }
    }

    // Page Object

    // wishListTableComponents

    public List<WishListTableComponent> getWishListTableComponents()
    {
        return wishListTableComponents;
    }

    // Functional

//get count of table elements

    public int getwishListTableComponentsCount()
    {
        return getWishListTableComponents().size();
    }

//get all names from table

    public List<String> getwishListTableComponentNames()
    {
        List<String> wishListTableComponentNames = new ArrayList<>();

        for (WishListTableComponent current : getWishListTableComponents())
        {
            wishListTableComponentNames.add(current.getNameText());
        }
        return wishListTableComponentNames;
    }


//get table component by name

    protected WishListTableComponent getWishListTableComponentByName(String productName)
    {
        WishListTableComponent result = null;
        for (WishListTableComponent current : getWishListTableComponents())
        {
            if (current.getNameText().toLowerCase()
                    .equals(productName.toLowerCase())) //?????
            {
                result = current;
                break;
            }
        }
        if (result == null)
        {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ProductName: " + productName + " not Found.");
        }
        return result;
    }


    // TODO Change to Product
    public String getProductComponentPriceByName(String productName)
    {
        return getProductComponentByName(productName).getPriceText();
    }

    // TODO Change to Product
    public String getProductComponentDescriptionByName(String productName)
    {
        return getProductComponentByName(productName).getPartialDescriptionText();
    }

    // TODO Change to Product
    public void clickProductComponentAddToCartButtonByName(String productName)
    {
        getProductComponentByName(productName).clickAddToCartButton();
    }

    // TODO Change to Product
    public void clickProductComponentAddToWishButtonByName(String productName)
    {
        getProductComponentByName(productName).clickAddToWishButton();
    }

    public String getProductComponentPriceByProduct(Product product)
    {
        return getProductComponentPriceByName(product.getName());
    }

    public String getProductComponentDescriptionByProduct(Product product)
    {
        return getProductComponentDescriptionByName(product.getName());
    }

    // Business Logic

    public WishListTableComponent getProductComponentByName(Product product)
    {
        return getProductComponentByName(product.getName());
    }

}
