package NonLoginUser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddOnProductPage {

    @Test
    public void addOnProductPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");
        driver.findElement(By.xpath("//div[contains(@class, 'caption')]//a[text()='MacBook']")).click();
        driver.findElement(By.xpath("//button[contains(@id,'button-cart')]")).click();
        driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).click();
    }
}
