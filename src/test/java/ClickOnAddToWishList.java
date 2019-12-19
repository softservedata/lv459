import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ClickOnAddToWishList  extends LocalTestRunner {

    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";

    By wishListField = By.id("wishlist-total");
    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By footerWishList = By.linkText("Wish List");
    By searchField = By.name("search");
    By productAppleCinema = By.linkText("Apple Cinema 30\"");
    By heartButton = By.xpath("//div[@id='content']//div[@class='col-sm-4']//button[contains(@onclick, 'wishlist.add')]");


    @Test
    public void clickDirectlyOnWishList() throws InterruptedException {

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(1000);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(1000);

        driver.findElement(openCartField).click();
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(1000);

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(1000);

        String expected = "Success: You have added MacBook to your wish list!";
        WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(1000);

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(1000);
        driver.findElement(wishListField).click();
    }

    @Test
    public void clickOnProductThenWishList() throws InterruptedException {

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(1000);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(1000);

        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("%" + Keys.ENTER);
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(1000);

        driver.findElement(productAppleCinema).click();
        Thread.sleep(1000);
        driver.findElement(heartButton).click();
        Thread.sleep(1000);

        String expected = "Success: You have added Apple Cinema 30\" to your wish list!";
        WebElement actual = driver.findElement(By.xpath("//div[@class='container']//div[@class='alert alert-success']"));

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(1000);

        driver.findElement(wishListField).click();
        Thread.sleep(1000);
    }

    @Test
    public void clickOnFooterWishList() throws InterruptedException {

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(1000);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 1000)", "");

        driver.findElement(footerWishList).click();
        Thread.sleep(1000);

    }
}
