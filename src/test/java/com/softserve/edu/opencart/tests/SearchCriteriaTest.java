package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
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
    private void findItemCaseOne(IProduct product) throws InterruptedException {
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
        // Choosing from the "Category" drop-down list "Components"
        loadSearchCriteriaPart().chooseCriteriaByName(Categories.COMPONENTS);
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart().clickCriteriaSearchButton();
        //
        // Getting "There is no product that matches the search criteria." label
        String actualUnsuccessfulPage = loadSearchUnsuccessPage().getNoProductMessageText();
        //
        // Checking if there is such message in the page
        Assert.assertTrue(loadSearchUnsuccessPage().getNoProductMessageText().contains(actualUnsuccessfulPage));
        //
        // Clicking on the "Search in subcategories" checkbox
        loadSearchCriteriaPart().clickCriteriaSubCategoryCheckBox();
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart().clickCriteriaSearchButton();
        //
        //
        SearchSuccessPage searchSuccessfulPage1 = loadSearchSuccessPage();
        ProductComponent actualProductComponent1 = searchSuccessfulPage1.getProductsDisplay()
                .getProductComponentByName(product);
        //
        // Checking product's name
        Assert.assertTrue(actualProductComponent1.getNameText().contains(product.getName()));
        //
        // Clicking on the "Search in product descriptions" checkbox
        loadSearchCriteriaPart().clickCriteriaDescription();
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart().clickCriteriaSearchButton();
        //
        // Returning to the previous state
        //HomePage homePage = searchSuccessfulPage.gotoHomePage();
        //
        // Checking am I on the home page
        //Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }
}
