package LoginUser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddOnProductPageLTest extends LocalTestRunner{
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";

    @Test
    public void addOnProductPageL() throws InterruptedException {

        // Goto Home Page
        driver.findElement(By.className("img-responsive")).click();

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("mac");
        Thread.sleep(1000);

        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(@class,'caption')]//a[text()='MacBook']")).click();
        driver.findElement(By.id("button-cart")).click();
        //driver.findElement(By.className("img-responsive")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(alertMessage.getText().contains("Success: You have added"));
        Thread.sleep(1000);
    }

}
