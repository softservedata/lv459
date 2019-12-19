package LoginUser;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class AddWithOptionsL {
    WebDriver driver;
    @Test
    public void addWithOptionsL() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");
        loginUser();
        driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//a[starts-with(.,'Apple Cinema')]")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[3]/div/div[2]/h4/a")).click();
        driver.findElement(By.xpath("//*[@id='input-option218']/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='input-option223']/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='input-option223']/div[2]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='input-option217']")).click();
        driver.findElement(By.xpath("//option[starts-with(.,'Red')]")).click();
        driver.findElement(By.xpath("//*[@id='input-option209']")).click();
        driver.findElement(By.xpath("//*[@id='input-option209']")).sendKeys("test");
        Robot robot = new Robot();
        driver.findElement(By.xpath("//*[@id='button-upload222']/i")).click();
        robot.setAutoDelay(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\talia\\Desktop\\marshmello.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(3000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Alert alert_box = driver.switchTo().alert();
        alert_box.accept();
        driver.findElement(By.id("button-cart")).click();

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
