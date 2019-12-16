import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NotLoggedInUserClickAddToWishListTest {

    By macBookProductHeart = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]");//CHANGE XPATH

    @Test
    public void testNotLoggedInUserClickAddToWishList() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
               this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://192.168.159.131/opencart/upload/index.php?route=common/home");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");
        Thread.sleep(1000);

        driver.findElement(macBookProductHeart).click();
        //WebElement actual = driver.findElement(By.xpath("/html/body/div[2]/div[1]"));//CHANGE XPATH
        WebElement actual = driver.findElement(By.xpath("/html/body/div[2]/div[1]/i"));//CHANGE XPATH

        String expected = "You must login or create an account to save MacBook to your wish list!";
        Assert.assertEquals(expected, actual.getText()); //don't work asser, how to get message?

        Thread.sleep(2000);
        driver.quit();
    }
}
