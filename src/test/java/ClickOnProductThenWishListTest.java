import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClickOnProductThenWishListTest {

    By wishListField = By.id("wishlist-total");
    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");
    By searchField = By.name("search");
    By productAppleCinema = By.linkText("Apple Cinema 30\"");
    By heartButton = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]");//CHANGE XPATH


    /**
     * Test when user search element and click on it and then click on wishlist button.
     * Precondition: user user is logged in, Wish List is empty
     */
    @Test //ПОМІНЯТИ НАЗВИ КЛАСІВ І МЕТОДІВ
    public void testClickOnProductThenWishList() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
               this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://192.168.159.131/opencart/upload/index.php?route=account/login");

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(2000);

        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("%" + Keys.ENTER);
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(2000);

        driver.findElement(productAppleCinema).click();
        Thread.sleep(1000);
        driver.findElement(heartButton).click();
        Thread.sleep(1000);
        driver.findElement(wishListField).click();
        Thread.sleep(2000);
        // Assert.assertEquals();

        driver.quit();

    }
}
