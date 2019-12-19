package LoginUser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteOnShopCartL {
    WebDriver driver;

    @Test
    public void deleteOnShopCarL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");
        loginUser();
        driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]/i")).click();
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();
    }
    public void loginUser() throws InterruptedException {
        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("user1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("password"));
        driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).submit();
    }

}