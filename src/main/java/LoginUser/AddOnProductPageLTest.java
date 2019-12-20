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
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";
    private final String DELETE_ON_DROPDOWN_MENU = "//table[@class='table table-striped']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";

    /**
     * Method Add product from specific product page.
     * @throws InterruptedException
     */
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

        //Open Cart by Drop Down Menu
        driver.findElement(By.xpath(DROP_DOWN_CART_BUTTON)).click();
        Thread.sleep(1000);
        //Delete product
        driver.findElement(By.xpath(String.format(DELETE_ON_DROPDOWN_MENU,"MacBook"))).click();
        Thread.sleep(1000);

        //Open Cart by Drop Down Menu again to check is it empty
        driver.findElement(By.xpath(DROP_DOWN_CART_BUTTON)).click();
        Thread.sleep(1000);

        //Check is Cart empty
        WebElement alertMessage1 = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//p"));
        Assert.assertTrue(alertMessage1.getText().contains("Your shopping cart is empty!"));
        Thread.sleep(1000);
    }

}
