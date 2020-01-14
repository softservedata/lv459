package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ListAndGridTest extends LocalTestRunner {

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {ProductRepository.get().getAppleCinema30()}
        };
    }

    /**
     * Pressing "List" button on "Search" window.
     */
    @Test(dataProvider = "searchData")
    public void findItemCaseOne(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessPage = loadApplication()
                .successfulSearch(product);
        // Clicking "List" button
        ProductsDisplayComponent productsDisplayComponent = searchSuccessPage
                .getProductsDisplay()
                .viewProductsByList();

        // Check
        Assert.assertTrue(productsDisplayComponent.statusListViewButton());
        //
        // Return to the Previous State
        HomePage homePage = searchSuccessPage.gotoHomePage();
        //
        // Check
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

}
