package NonLoginUser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DltOnShopCrt {
    @Test
    public void dltOnShopCrt(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());

        WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");

        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]/i")).click();
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();
    }
}
