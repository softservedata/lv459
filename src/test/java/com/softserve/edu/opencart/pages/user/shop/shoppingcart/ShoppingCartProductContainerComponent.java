package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import com.softserve.edu.opencart.data.IProduct;
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

        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_TABLE_COMPONENTS))) {
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
    public int getShoppingCartProductComponentsCount(){

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

    // get ShoppingCart IProduct Component By Name

                            // чи тут має бути String productName чи IProduct product
    protected ShoppingCartProductComponent getShoppingCartProductComponentByName(IProduct product)
    {
        ShoppingCartProductComponent result = null;
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents())
        {
            if (current.getProductNameText().toLowerCase()
                    .equals(product.getName().toLowerCase()))
            {
                result = current;
                break;
            }
        }
        if (result == null)
        {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ProductName: " + product.getName() + " not Found.");
        }
        return result;
    }

    //get IProduct Price By Name
    public String getProductPriceByName(IProduct product){
        return getShoppingCartProductComponentByName(product).getUnitPriceText();
    }

    //get IProduct Total Price By Name
    public String getProductTotalPriceByName(IProduct product){
        return getShoppingCartProductComponentByName(product).getTotalPriceText();
    }

    //get IProduct Model By Name
    public String getProductModelByName(IProduct product){
        return getShoppingCartProductComponentByName(product).getModelText();
    }

    //click Quantity By IProduct Name
    public void clickQuantityByProductName(IProduct product){
        getShoppingCartProductComponentByName(product).clickQuantityField();
    }

    //clear Quantity By IProduct Name
    public void clearQuantityByProductName(IProduct product){
        getShoppingCartProductComponentByName(product).clearQuantityField();
    }

    //type Quantity By IProduct Name
    public void typeQuantityByProductName(IProduct product, String quantity){
        getShoppingCartProductComponentByName(product).typeQuantity(quantity);
    }

    //click Refresh Button By IProduct Name
    public void clickRefreshButtonByProductName(IProduct product){
        getShoppingCartProductComponentByName(product).clickRefreshButton();
    }

    //click Delete Button By IProduct Name
    public void clickDeleteButtonByProductName(IProduct product){
        getShoppingCartProductComponentByName(product).clickDeleteButton();
    }


        //Business logic


    //?????  It works on 'ProductsContainerComponent' class but not here?????
/*
    public ShoppingCartProductComponent getProductComponentByName(IProduct product)
    {
        return getProductComponentByName(product.getName());
    }*/

}