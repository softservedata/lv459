import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WishListIsEmptyByDefaultTest {

    By wishListField = By.id("wishlist-total");
    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");

    /**
     * Precondition: user user is logged in, Wish List is empty
     */
    @Test
    public void testWishListIsEmptyByDefault() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://192.168.159.131/opencart/upload/");

        driver.findElement(wishListField).click();
        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);//For presentation only

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(2000);

        WebElement actual = driver.findElement(By.xpath("//*[@id=\"content\"]/p"));
        String expected = "Your wish list is empty.";

        Assert.assertEquals(expected, actual.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}