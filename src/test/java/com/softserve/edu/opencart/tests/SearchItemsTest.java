package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchItemsTest extends LocalTestRunner {


    //TODO
/*    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
        };
    }*/

    /**
     * Typing lower/upper case letters, numbers and symbol
     * in "Search" field.
     *
     * @throws Exception exception
     */
    @Test
    public void findItemCaseOne() throws Exception {
        // Test Data
        // SearchFilter searchFilter
        Product validProduct = ProductRepository.getAppleCinema30();
        //
        // Steps
        SearchSuccessPage searchSuccessPage = loadApplication().successfulSearch(validProduct);
        presentationSleep();
        ProductComponent actualProductComponent = searchSuccessPage.getProductsDisplay()
                .getProductComponentByName(validProduct);
        //
        // Check
        Assert.assertTrue(actualProductComponent.getNameText().contains(validProduct.getName()));
        //
        // TODO
        // Continue Searching. Use SearchCriteria from SearchCriteriaPart
        //
        // Return to Previous State
        HomePage homePage = searchSuccessPage.gotoHomePage();
        //
        // Check (optional)
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }
}
