import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddElementToShoppingCartTest {
    By wishListField = By.id("wishlist-total");
    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By macBookProductHeart = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]");//CHANGE XPATH
    By addToShoppingCart = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button"); //CHANGE XPATH
    By shoppingCart = By.xpath("//span[@id='cart-total']");

    @Test
    public void testAddElementToShoppingCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
               this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://192.168.159.131/opencart/upload/index.php?route=account/login");

        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);

        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(inputPassword).submit();
        Thread.sleep(2000);

        driver.findElement(openCartField).click();
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(2000);

        driver.findElement(macBookProductHeart).click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(2000);
        driver.findElement(wishListField).click();
        Thread.sleep(2000);

        driver.findElement(addToShoppingCart).click();

//       String expected = "Success: You have added MacBook to your shopping cart!"; //ТРЕБА РОБИТИ ПО CONTAINS B DIV
//        WebElement actual = driver.findElement(By.xpath("//div[contains(text(), 'Success: You have added iPhone to your shopping cart')]"));//CHANGE XPATH (how to get message????)
//        Assert.assertEquals(expected, actual.getText());
//        Thread.sleep(2000);

        //go to shopping cart
        driver.findElement(shoppingCart).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
