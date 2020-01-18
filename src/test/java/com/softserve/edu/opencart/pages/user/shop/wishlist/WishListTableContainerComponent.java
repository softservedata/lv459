package com.softserve.edu.opencart.pages.user.shop.wishlist;

import java.util.ArrayList;
import java.util.List;
import com.softserve.edu.opencart.data.IProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * <h3> Wish List Table Container Component class.</h3>
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
     * <h3>This method inits elements.</h3>
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
     * <h3>This method gets wishListTableComponents.</h3>
     */
    public List<WishListTableComponent> getWishListTableComponents() {
        return wishListTableComponents;
    }


    // Functional

    /**
     * <h3>This method gets count of table elements.</h3>
     */
    public int getWishListTableComponentsCount() {
        return getWishListTableComponents().size();
    }

    /**
     * <h3>This method gets all names from table.</h3>
     */
    public List<String> getWishListTableComponentNames() {
        List<String> wishListTableComponentNames = new ArrayList<>();
        for (WishListTableComponent current : getWishListTableComponents()) {
            wishListTableComponentNames.add(current.getNameText());
        }
        return wishListTableComponentNames;
    }

    /**
     * <h3>This method gets table component by name.</h3>
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
     * <h3>This method gets table component price by name.</h3>
     */
    public String getWishListTableComponentPriceByName(IProduct productName) {
        return getWishListTableComponentByName(productName).getUnitPriceText();
    }

    /**
     * <h3>This method gets table component model by name.</h3>
     */
    public String getWishListTableComponentModelByName(IProduct productName) {
        return getWishListTableComponentByName(productName).getModelText();
    }

    /**
     * <h3>This method clicks table component add to cart button by name.</h3>
     */
    public void clickWishListTableComponentAddToCartButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickAddToCartButton();
    }

    /**
     * <h3>This method clicks table component remove button by name.</h3>
     */
    public void clickWishListTableComponentRemoveButtonByName(IProduct productName) {
        getWishListTableComponentByName(productName).clickRemoveFromWishListButton();
    }

    /**
     * <h3>This method clicks table component on name.</h3>
     */
    public void clickWishListTableComponentOnName(IProduct productName) {
        getWishListTableComponentByName(productName).clickProductName();
    }

}
