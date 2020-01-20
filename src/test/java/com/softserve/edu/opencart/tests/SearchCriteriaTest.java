package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.shop.SamsungSyncMaster941BWPage;

public class SearchCriteriaTest extends LocalTestRunner {

    @DataProvider
    private Object[][] searchDataCaseOne() {
        return new Object[][]{
                {ProductRepository.get().getSamsungSyncMaster941BW()}
        };
    }
    /**
     * Typing in "Search Criteria" field value "Samsung SyncMaster 941BW"
     * checking if there is this word in the description and
     * checking subcategory if there is "Samsung SyncMaster 941BW".
     *
     * 
     */

    @Test(dataProvider = "searchDataCaseOne")
    private void findItemCaseOne(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchSuccessPage searchSuccessfulPage = loadApplication()
                .successfulSearch(product);
        // Getting Product Component By Name
        ProductComponent actualProductComponent = searchSuccessfulPage
                .getProductsDisplay()
                .getProductComponentByName(product);
        //
        // Checking product's name
        Assert.assertTrue(actualProductComponent.getNameText().contains(product.getName()));
        //
        // Choosing from the "Category" drop-down list "Components"
        loadSearchCriteriaPart()
                .chooseCriteriaByName(Categories.COMPONENTS);
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart()
                .clickCriteriaSearchButton();
        //
        // Getting "There is no product that matches the search criteria." label
        String actualUnsuccessfulPage = loadSearchUnsuccessPage()
                .getNoProductMessageText();
        //
        // Checking if there is such message in the page
        Assert.assertTrue(loadSearchUnsuccessPage().getNoProductMessageText().contains(actualUnsuccessfulPage));
        //
        // Clicking on the "Search in subcategories" checkbox
        loadSearchCriteriaPart()
                .clickCriteriaSubCategoryCheckBox();
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart()
                .clickCriteriaSearchButton();
        //
        // Checking if there is "Samsung SyncMaster 941BW" in subcategories
        SearchSuccessPage searchSuccessful = loadSearchSuccessPage();
        ProductComponent actualProduct = searchSuccessful
                .getProductsDisplay()
                .getProductComponentByName(product);
        //
        // Checking product's name
        Assert.assertTrue(actualProduct.getNameText().contains(product.getName()));
        //
        // Clicking on the "Search in product descriptions" checkbox
        loadSearchCriteriaPart()
                .clickCriteriaDescription();
        //
        // Clicking on the "Search" button
        loadSearchCriteriaPart()
                .clickCriteriaSearchButton();
        //
        // Opening "Samsung SyncMaster 941BW" page and checking if the is this name in description
        SamsungSyncMaster941BWPage samsungSyncMaster941BWPage = loadSearchSuccessPage()
                .gotoSamsungSyncMaster941BWPage(product);
        String actualProductResult = samsungSyncMaster941BWPage
                .getTitleText();
        // Checking product's name
        Assert.assertTrue(actualProductResult.contains(product.getName()));
        //
        // Opening "Components" category page
        loadComponentsTopPart()
                .gotoShowAllComponents();
        Assert.assertTrue(loadComponentsPart().getMonitorsText().contains(loadComponentsPart().MONITORS));
        //
        // Opening "Monitors" subcategory page
        loadComponentsPart()
                .clickOnMonitors();
        Assert.assertTrue(actualProductResult.contains(product.getName()));

        //
        // Returning to the previous state
        HomePage homePage = loadComponentsTopPart()
                .gotoHomePage();
        //
        // Checking am I on the home page
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }
}
