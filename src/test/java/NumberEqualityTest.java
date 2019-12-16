import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NumberEqualityTest {

    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By macBookProductHeart = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]");//CHANGE XPATH
    //By macBookProductHeart = By.xpath("//*[@class= 'row']//div[@class='button-group']//button[contains(., 'fa fa-heart')]"); //DO NOT WHY???
    By iPhoneProductHeart = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[2]");//CHANGE XPATH
    @Test
    public void testNumberEquality() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
               this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://192.168.159.131/opencart/upload/index.php?route=account/login");

        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);
//        WebElement element =  driver.findElement(inputPassword);
//        element.sendKeys(System.getenv().get("PASSWORD"));
//        element.submit();
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(inputPassword).submit();
        Thread.sleep(2000);

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");


        driver.findElement(macBookProductHeart).click();
        driver.findElement(iPhoneProductHeart).click();

        WebElement actual = driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]//span"));
        Assert.assertEquals("Wish List (2)", actual.getText()); //WHY DOES NOT WORK???
        Thread.sleep(2000);

        driver.quit();

    }
}
