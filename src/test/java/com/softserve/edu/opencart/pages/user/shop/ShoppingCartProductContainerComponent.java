package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.Product;
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

    // get ShoppingCart Product Component By Name

                            // чи тут має бути String productName чи Product product
    protected ShoppingCartProductComponent getShoppingCartProductComponentByName(Product product)
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

    //get Product Price By Name
    public String getProductPriceByName(Product product){
        return getShoppingCartProductComponentByName(product).getUnitPriceText();
    }

    //get Product Total Price By Name
    public String getProductTotalPriceByName(Product product){
        return getShoppingCartProductComponentByName(product).getTotalPriceText();
    }

    //get Product Model By Name
    public String getProductModelByName(Product product){
        return getShoppingCartProductComponentByName(product).getModelText();
    }

    //click Quantity By Product Name
    public void clickQuantityByProductName(Product product){
        getShoppingCartProductComponentByName(product).clickQuantityField();
    }

    //clear Quantity By Product Name
    public void clearQuantityByProductName(Product product){
        getShoppingCartProductComponentByName(product).clearQuantityField();
    }

    //type Quantity By Product Name
    public void typeQuantityByProductName(Product product, String quantity){
        getShoppingCartProductComponentByName(product).typeQuantity(quantity);
    }

    //click Refresh Button By Product Name
    public void clickRefreshButtonByProductName(Product product){
        getShoppingCartProductComponentByName(product).clickRefreshButton();
    }

    //click Delete Button By Product Name
    public void clickDeleteButtonByProductName(Product product){
        getShoppingCartProductComponentByName(product).clickDeleteButton();
    }


        //Business logic


    //?????  It works on 'ProductsContainerComponent' class but not here?????

   /* public ShoppingCartProductComponent getProductComponentByName(Product product)
    {
        return getProductComponentByName(product.getName());
    }*/

}