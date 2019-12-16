import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClickOnFooterWishListTest {

    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");
    By footerWishList = By.linkText("Wish List");

    @Test
    public void testClickOnFooterWishList() throws InterruptedException {
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

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 1000)", "");

        driver.findElement(footerWishList).click();
        Thread.sleep(2000);
        // Assert.assertEquals();
        driver.quit();
    }
}
