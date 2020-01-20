package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchRequestURITooLongPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchItemsTest extends LocalTestRunner {

    @DataProvider
    private Object[][] searchDataCaseOne() {
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
                {ProductRepository.get().getCustomItem("10.")},
                // Testing length (one letter)
                {ProductRepository.get().getCustomItem("A")}
        };
    }

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
        // Returning to the previous state
        HomePage homePage = searchSuccessfulPage
                .gotoHomePage();
        //
        // Checking am I on the home page
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

    private String generateRandomString(int length) {
        Random r = new Random();
        char[] subset = NUMBERS_AND_LETTERS.toCharArray();
        char[] buf = new char[length];
        for (int i = 0; i < buf.length; i++) {
            int index = r.nextInt(subset.length);
            buf[i] = subset[index];
        }
        return new String(buf);
    }

    @DataProvider
    private Object[][] searchDataCaseTwo() {
        return new Object[][]{
                // Empty "Search" field
                {ProductRepository.get().getCustomItem(new String())},
                // SQL command
                {ProductRepository.get().getCustomItem("; DROP DATABASE *;")},
                // 255 letters
                {ProductRepository.get().getCustomItem(generateRandomString(TWO_HUNDRED_AND_FIFTY_FIVE))}
        };
    }

    @Test(dataProvider = "searchDataCaseTwo")
    private void findItemCaseTwo(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchUnsuccessPage searchUnsuccessfulPage = loadApplication()
                .unsuccessfulSearch(product);
        // Getting "There is no product that matches the search criteria." label
        String actualUnsuccessfulPage = searchUnsuccessfulPage
                .getNoProductMessageText();
        //
        // Checking if there is such message in the page
        Assert.assertTrue(searchUnsuccessfulPage.getNoProductMessageText().contains(actualUnsuccessfulPage));
        //
        // Returning to the previous state
        HomePage homePage = searchUnsuccessfulPage
                .gotoHomePage();
        //
        // Checking am I on the home page
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

    @DataProvider
    private Object[][] searchDataCaseThree() {
        return new Object[][]{
                // 65536 letters
                {ProductRepository.get().getCustomItem(generateRandomString(SIXTY_FIVE_THOUSANDS_FIVE_HUNDRED_AND_THIRTY_SIX))}
        };
    }

    @Test(dataProvider = "searchDataCaseThree")
    private void findItemCaseThree(IProduct product) {
        //
        // Steps
        // Typing in the "Search" field.
        SearchRequestURITooLongPage searchRequestURITooLongPage = loadApplication()
                .unsuccessfulSearchRequestURITooLong(product);
        // Getting "Request-URI Too Long" label
        String actualRequestURITooLongPage = searchRequestURITooLongPage
                .getRequestToLongMessageText();
        //
        // Checking if there is such message in the page
        Assert.assertTrue(searchRequestURITooLongPage.getRequestToLongMessageText().contains(actualRequestURITooLongPage));
    }

}
