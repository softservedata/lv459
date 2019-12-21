import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class ClickOnAddToWishListTest extends LocalTestRunner {

    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";

    By wishListField = By.id("wishlist-total");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By footerWishList = By.linkText("Wish List");
    By searchField = By.name("search");
    By productAppleCinema = By.linkText("Apple Cinema 30\"");
    By heartButton = By.xpath("//div[@id='content']//div[@class='col-sm-4']//button[contains(@onclick, 'wishlist.add')]");


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

        String expected = "Success: You have added MacBook to your wish list!";
        WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(300);

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(300);
        driver.findElement(wishListField).click();
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

        String expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        WebElement actual = driver.findElement(By.xpath("//div[@class='container']//div[@class='alert alert-success']"));

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(300);

        driver.findElement(wishListField).click();
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
