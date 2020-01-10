package com.softserve.edu.opencart.pages.user.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductContainerComponent {

    private WebDriver driver;

    private final String PRODUCT_TABLE_COMPONENTS = "div.table-responsive tbody tr";

    private List<ShoppingCartProductComponent> shoppingCartProductComponents;


    public ShoppingCartProductContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        shoppingCartProductComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(PRODUCT_TABLE_COMPONENTS))) {
            shoppingCartProductComponents.add(new ShoppingCartProductComponent(current));

        }
    }

        //Page Object

    // wishListTableComponents
    public List<ShoppingCartProductComponent> getShoppingCartProductComponents() {
        return shoppingCartProductComponents;
    }

        //Functional

    // get ShoppingCart  ProductComponents Count
    public int getShoppingCartProductComponentsCount()
    {
        return getShoppingCartProductComponents().size();
    }

    public List<String> getShoppingCartProductComponentNames()
    {
        List<String> shoppingCartProductComponentNames = new ArrayList<>();
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents())
        {
            shoppingCartProductComponentNames.add(current.getProductNameText());
        }
        return shoppingCartProductComponentNames;
    }

    // get ShoppingCart Product Component By Name
    protected ShoppingCartProductComponent getShoppingCartProductComponentByName(String productName)
    {
        ShoppingCartProductComponent result = null;
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents())
        {
            if (current.getProductNameText().toLowerCase()
                    .equals(productName.toLowerCase()))
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

        //Business logic

}