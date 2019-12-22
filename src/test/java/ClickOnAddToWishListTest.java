import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class ClickOnAddToWishListTest extends LocalTestRunner {

    @Test
    public void clickDirectlyOnWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        driver.findElement(openCartField).click();
        Thread.sleep(300);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(300);

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(300);

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(300);
        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//div[@id='content']//table[@class='table table-bordered table-hover']//td[@class='text-left']/a"));

        Assert.assertTrue(actual.getText().contains("MacBook"));
        Thread.sleep(300);
    }

    @Test
    public void clickOnProductThenWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("%" + Keys.ENTER);
        Thread.sleep(300);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(300);

        driver.findElement(productAppleCinema).click();
        Thread.sleep(300);
        driver.findElement(heartButton).click();
        Thread.sleep(300);

        driver.findElement(wishListField).click();
        WebElement actual = driver.findElement(By.xpath("//div[@id='content']//table[@class='table table-bordered table-hover']//td[@class='text-left']/a"));

        Assert.assertTrue(actual.getText().contains("Apple Cinema 30\""));
        Thread.sleep(300);
    }

    @Test
    public void clickOnFooterWishList() throws InterruptedException {

        ClickOnAddToWishListTest clickOnAddToWishList = new ClickOnAddToWishListTest();
        clickOnAddToWishList.logIn();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 130)", "");

        driver.findElement(footerWishList).click();
        Thread.sleep(300);
    }
}
