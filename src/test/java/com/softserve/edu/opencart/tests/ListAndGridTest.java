package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;

public class ListAndGridTest extends LocalTestRunner {

    @DataProvider
    private Object[][] searchData() {
        return new Object[][]{
                {ProductRepository.get().getAppleCinema30()}
        };
    }

    /**
     * Pressing "List" button on "Search" window.
     */
    @Test(dataProvider = "searchData")
    private void caseOne(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessPage = loadApplication()
                .successfulSearch(product);
        // Clicking "List" button
        ProductsDisplayComponent productsDisplayComponent = searchSuccessPage
                .getProductsDisplay()
                .viewProductsByList();

        // Checking if button is active
        Assert.assertTrue(productsDisplayComponent.statusListViewButton());
        //
        // Returning to the previous state
        HomePage homePage = searchSuccessPage
                .gotoHomePage();
        //
        // Checking
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

    /**
     * Pressing "Grid" button on "Search" window.
     */
    @Test(dataProvider = "searchData")
    private void caseTwo(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessPage = loadApplication()
                .successfulSearch(product);
        // Clicking "List" button
        ProductsDisplayComponent productsDisplayComponent = searchSuccessPage
                .getProductsDisplay()
                .viewProductsByGrid();

        // Checking if button is active
        Assert.assertTrue(productsDisplayComponent.statusGridViewButton());
        //
        // Returning to the previous state
        HomePage homePage = searchSuccessPage
                .gotoHomePage();
        //
        // Checking
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

}
