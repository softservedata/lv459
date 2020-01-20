package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.shop.SamsungSyncMaster941BWPage;


public class SearchSuccessPage extends SearchCriteriaPart {

    private ProductsDisplayComponent productsDisplay;
    private ProductsContainerComponent productsContainerComponent;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        productsDisplay = new ProductsDisplayComponent(driver);
        productsContainerComponent = new ProductsContainerComponent(driver);
    }

    // Page Object

    // productsDisplay

    public ProductsDisplayComponent getProductsDisplay() {
        return productsDisplay;
    }

    // Functional

    // Business Logic

    public SearchSuccessPage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new SearchSuccessPage(driver);
    }

    // TODO Use Enum
    public SearchSuccessPage sortProductsByCriteria(String text) {
        // productsDisplay.setInputSort(text);
        return new SearchSuccessPage(driver);
    }

    // TODO Use Enum
    public SearchSuccessPage showProductsByCount(String text) {
        // productsDisplay.setInputLimit(text);
        return new SearchSuccessPage(driver);
    }


    public SearchSuccessAlertPage AddToWishButtonByName(IProduct product) {

        productsDisplay.clickProductComponentAddToWishButtonByName(product);
        return new SearchSuccessAlertPage(driver);
    }

    //    public ProductInfoPage gotoProductInfo(IProduct product) {
//        getProductsDisplay().getProductComponentByName(product).clickName();
//        return new ProductInfoPage(driver);
//    }
    public SamsungSyncMaster941BWPage gotoSamsungSyncMaster941BWPage(IProduct product) {
        productsContainerComponent.getProductComponentByName(product).clickName();
        return new SamsungSyncMaster941BWPage(driver);
    }

}
