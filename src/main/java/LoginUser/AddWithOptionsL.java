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

public class AddWithOptionsL extends LocalTestRunner {
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String ADD_TO_CART_BY_STARTS_WITH = "//a[starts-with(.,'%s')]/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";

    @Test
    public void addWithOptionsL() throws InterruptedException, AWTException {

        driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).click();
        Thread.sleep(2000);

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("Apple Cinema");
        Thread.sleep(1000);

        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();
        Thread.sleep(1000);


        //Add Apple Cinema to Cart
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BY_STARTS_WITH, "Apple Cinema"))).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[3]/div/div[2]/h4/a")).click();
        driver.findElement(By.xpath("//*[@id='input-option218']/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='input-option223']/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='input-option223']/div[2]/label/input")).click();
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//option[starts-with(.,'Red')]")).click();
        driver.findElement(By.xpath("//*[@id='input-option209']")).click(); //placeholder
        driver.findElement(By.xpath("//*[@id='input-option209']")).sendKeys("test");
        Robot robot = new Robot();
        driver.findElement(By.xpath("//*[@id='button-upload222']/i")).click();//starts-with id text
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

}
