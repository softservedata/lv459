package LoginUser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DltOnDrDwMenuL extends LocalTestRunner{
    private final String Add_To_Cart_From_Home_Page =
            "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";
    private final String DELETE_ON_DROPDOWN_MENU = "//table[@class='table table-striped']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";

    /**
     * Method Delete product from dropdown menu
     *
     * Positive test
     * @throws InterruptedException
     */
    @Test
    public void deleteOnDropDownMenu() throws InterruptedException {


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
        WebElement alertMessage = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//p"));
        Assert.assertTrue(alertMessage.getText().contains("Your shopping cart is empty!"));
        Thread.sleep(1000);


    }

}
