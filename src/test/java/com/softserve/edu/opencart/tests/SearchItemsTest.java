package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
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
                // Lower/upper case letters, numbers and symbol
                {ProductRepository.get().getAppleCinema30()},
                // Lower/upper case letters
                {ProductRepository.get().getMacBook()},
                // Lower case letters and number
                {ProductRepository.get().getCustomItem("ema 30")},
                // Lower case letters and symbol
                {ProductRepository.get().getCustomItem("ab 10.1")},
                // Upper case letters and numbers
                {ProductRepository.get().getCustomItem("LP3065")},
                // Upper case letters and symbol
                {ProductRepository.get().getCustomItem("Cinema 30\"")},
                // Numbers and symbol
                {ProductRepository.get().getCustomItem("10.")}
        };
    }

    @Test(dataProvider = "searchData")
    public void findItemCaseOne(IProduct product) {
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
