import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SaveAfterLogoutTest {

    By wishListField = By.id("wishlist-total");
    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By canonProductHeart = By.xpath("//*[@id=\"content\"]/div[2]/div[4]/div/div[3]/button[2]");// CHANGE XPATH
    By myAccount = By.xpath("//div[@class='container']//div[@id='top-links']//span[@class='caret']");
    By logOut = By.linkText("Logout");
    By logIn = By.linkText("Login");

    @Test
    public void testClickDirectlyOnWishList() throws InterruptedException {

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

        driver.findElement(openCartField).click();
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(2000);

        driver.findElement(canonProductHeart).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(2000);
        driver.findElement(wishListField).click();
        Thread.sleep(2000);

        driver.findElement(myAccount).click();
        Thread.sleep(2000);

        driver.findElement(logOut).click();
        Thread.sleep(2000);

        driver.findElement(myAccount).click();
        Thread.sleep(2000);

        driver.findElement(logIn).click();
        Thread.sleep(2000);

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(2000);

        driver.findElement(wishListField).click();
        Thread.sleep(2000);

        driver.quit();
    }
}