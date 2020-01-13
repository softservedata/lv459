package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchItemsTest extends LocalTestRunner {


    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                // Checking lower/upper case letters, numbers and symbol
                {ProductRepository.getAppleCinema30()},
                // Checking lower/upper case letters
                {ProductRepository.getMacBook()}
        };
    }

    @Test(dataProvider = "searchData")
    public void findItemCaseOne(Product product){
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessPage = loadApplication().successfulSearch(product);
        // Checking component
        ProductComponent actualProductComponent = searchSuccessPage.getProductsDisplay()
                .getProductComponentByName(product);
        //
        // Check
        Assert.assertTrue(actualProductComponent.getNameText().contains(product.getName()));
        //
        // Return to the Previous State
        HomePage homePage = searchSuccessPage.gotoHomePage();
        //
        // Check
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

}
