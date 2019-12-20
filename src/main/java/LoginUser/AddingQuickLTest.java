package LoginUser;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddingQuickLTest extends LocalTestRunner{
    private final String Add_To_Cart_From_Home_Page =
            "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    @Test
    public void addingQuickL() throws InterruptedException {

        // Goto Home Page
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("mac");
        Thread.sleep(1000);

        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();
        Thread.sleep(1000);

        //Add to Cart MacBook
        driver.findElement(By.xpath(String.format(Add_To_Cart_From_Home_Page, "MacBook"))).click();

        //Check by message does product successfully are added to Cart.
        WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertTrue(alertMessage.getText().contains("Success: You have added"));
        Thread.sleep(1000);

    }


}
