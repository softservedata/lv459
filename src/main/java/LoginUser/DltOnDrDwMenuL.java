package LoginUser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DltOnDrDwMenuL {
    @Test
    public void deleteOnDropDownMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginUser logUser = new LoginUser();
        logUser.loginUser();
        driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[5]/button")).click();

    }
}
