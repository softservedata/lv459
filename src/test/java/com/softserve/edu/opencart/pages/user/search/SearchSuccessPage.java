package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.IProduct;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.WebElement;


public class SearchSuccessPage extends SearchCriteriaPart {

    private ProductsDisplayComponent productsDisplay;
    private SearchCriteriaPart searchCriteriaPart;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        productsDisplay = new ProductsDisplayComponent(driver);
        searchCriteriaPart = new SearchCriteriaPart(driver) {
            @Override
            public void clickCriteriaSubCategoryByName(Categories subcategory) {
                super.clickCriteriaSubCategoryByName(subcategory);
            }
        };
    }

    // Page Object

    // productsDisplay

    public ProductsDisplayComponent getProductsDisplay() {
        return productsDisplay;
    }

    public SearchCriteriaPart getSearchCriteriaPart() {
        return searchCriteriaPart;
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

}
