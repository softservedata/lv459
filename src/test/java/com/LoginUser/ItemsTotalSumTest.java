package com.LoginUser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemsTotalSumTest extends LocalTestRunner {
    private final String Add_To_Cart_From_Home_Page =
            "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";
    private final String DELETE_ON_DROPDOWN_MENU = "//table[@class='table table-striped']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";
    private final String Quantity_Input = "//div[@class='table-responsive']//tbody//tr//a[contains(.,%s)]/../following-sibling::td//input";
    private final String DELETE_PRODUCT_ON_CART_PAGE= "//div[@class='table-responsive']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times-circle']";
    private final String SHOPPING_CART_BUTTON = "//ul[@class='list-inline']//i[@class='fa fa-shopping-cart']";

    /**
     * Test checks items on drop-down menu button.
     * If user add a product Item needs to change.
     * @throws InterruptedException
     */
    @Test
    public void checkDropDownItemsTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("mac");


        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();


        //Add to Cart MacBook
        driver.findElement(By.xpath(String.format(Add_To_Cart_From_Home_Page, "MacBook"))).click();

        driver.navigate().refresh();


        String pattern = "^\\d+";
        String text = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        m.reset();
        while (m.find()) {

            System.out.print(text.substring(m.start(), m.end()));
            Assert.assertEquals("1", text.substring(m.start(), m.end()));
        }

        //Assert.assertTrue(text.contains("Your shopping cart is empty!"));

    }

    /**
     * Test checks total sum on drop-down menu button.
     * If user add a product total sum needs to change.
     * @throws InterruptedException
     */
    @Test
    public void dropDownSumTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("mac");


        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();


        //Add to Cart MacBook
        driver.findElement(By.xpath(String.format(Add_To_Cart_From_Home_Page, "MacBook"))).click();

        driver.navigate().refresh();


        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String text = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        m.reset();
        while (m.find()) {

            //System.out.print(text.substring(m.start(), m.end()));
            Assert.assertEquals("500.00", text.substring(m.start(), m.end()));
        }
    }

    /**
     * Test checks does total sum change when user change quantity.
     *
     * Positive test
     * @throws InterruptedException
     */
    @Test
    public void checkTotalSum() throws InterruptedException {

        // Goto Home Page
        driver.findElement(By.cssSelector("#logo .img-responsive")).click();

        // Find product by typing 'mac' in search field
        driver.findElement(By.xpath(Search_Field)).click();
        driver.findElement(By.xpath(Search_Field)).clear();
        driver.findElement(By.xpath(Search_Field)).sendKeys("mac");


        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();


        //Add to Cart MacBook
        driver.findElement(By.xpath(String.format(Add_To_Cart_From_Home_Page, "MacBook"))).click();

        //Goto Shopping Cart page
        driver.findElement(By.xpath(SHOPPING_CART_BUTTON)).click();

        // Input quantity to MacBook
        driver.findElement(By.xpath(String.format(Quantity_Input, "MacBook"))).click();
        driver.findElement(By.xpath(String.format(Quantity_Input, "MacBook"))).clear();
        driver.findElement(By.xpath(String.format(Quantity_Input, "MacBook"))).sendKeys("2");


        //Refresh page and total sum needs to change
        driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//tr//a[contains(.,MacBook)]/../following-sibling::td//i[@class='fa fa-refresh']")).click();



        //Match is sum correct.
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        String text = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//tr//a[contains(.,MacBook)]/../following-sibling::td[@class='text-right']//../following-sibling::td")).getText();
        System.out.println(text);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        m.reset();
        while (m.find()) {

            //System.out.print(text.substring(m.start(), m.end()));
            Assert.assertEquals("1,000.00", text.substring(m.start(), m.end()));
        }
    }
}
