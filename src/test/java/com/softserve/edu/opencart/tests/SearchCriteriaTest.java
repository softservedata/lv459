package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchCriteriaPart;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchCriteriaTest extends LocalTestRunner {

    @DataProvider
    private Object[][] searchDataCaseOne() {
        return new Object[][]{
                {ProductRepository.get().getSamsungSyncMaster941BW()}
        };
    }

    @Test(dataProvider = "searchDataCaseOne")
    private void findItemCaseOne(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessfulPage = loadApplication().successfulSearch(product);
        // Getting Product Component By Name
        ProductComponent actualProductComponent = searchSuccessfulPage.getProductsDisplay()
                .getProductComponentByName(product);
        //
        // Checking product's name
        Assert.assertTrue(actualProductComponent.getNameText().contains(product.getName()));
        //
        searchSuccessfulPage.getSearchCriteriaPart().clickCriteriaSubCategoryByName(Categories.COMPONENTS);
        //clickCriteriaSubCategory
        //
        // Returning to the previous state
      //  HomePage homePage = searchSuccessfulPage.gotoHomePage();
        //
        // Checking am I on the home page
      //  Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }
}
