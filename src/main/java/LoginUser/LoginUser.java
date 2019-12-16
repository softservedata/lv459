package LoginUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUser {
    WebDriver driver;
    public void loginUser() throws InterruptedException {
        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
        driver.findElement(By.id("input-email")).sendKeys("user1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("password"));
        driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).submit();
    }
}
