import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

/**
 * <h3> This class contains three tests which verify if buttons Wish List works.</h3>
 */
public class ClickOnAddToWishListTest extends LocalTestRunner {
    /**
     * <h3>This method checks button when user directly click on 'Add to Wish List'.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void clickDirectlyOnWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        driver.findElement(openCartField).click();
        Thread.sleep(2000);// For Presentation Only

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(2000);// For Presentation Only

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//div[@id='content']//table[@class='table table-bordered table-hover']//td[@class='text-left']/a"));

        Assert.assertTrue(actual.getText().contains("MacBook"));
        Thread.sleep(2000);// For Presentation Only

    }

    /**
     * <h3>This method checks when user click on a product and then on 'Add to Wish List' button.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void clickOnProductThenWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("%" + Keys.ENTER);
        Thread.sleep(2000);// For Presentation Only

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(productAppleCinema).click();
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(heartButton).click();
        Thread.sleep(2000);// For Presentation Only

        driver.findElement(wishListField).click();
        WebElement actual = driver.findElement(By.xpath("//div[@id='content']//table[@class='table table-bordered table-hover']//td[@class='text-left']/a"));

        Assert.assertTrue(actual.getText().contains("Apple Cinema 30\""));
        Thread.sleep(2000);// For Presentation Only
    }

    /**
     *
     * <h3>This method checks 'Wish List' button on the footer.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void clickOnFooterWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 130)", "");

        driver.findElement(footerWishList).click();
        Thread.sleep(2000);// For Presentation Only
    }
}
