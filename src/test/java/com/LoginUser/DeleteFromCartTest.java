package com.LoginUser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteFromCartTest extends LocalTestRunner {
    private final String Add_To_Cart_From_Home_Page =
            "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String SHOPPING_CART_BUTTON = "//ul[@class='list-inline']//i[@class='fa fa-shopping-cart']";
    private final String DELETE_PRODUCT_ON_CART_PAGE= "//div[@class='table-responsive']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times-circle']";
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";
    private final String DELETE_ON_DROPDOWN_MENU = "//table[@class='table table-striped']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";


    /**
     * Test Delete product on Shopping Cart Page
     * And check is Page empty when product was deleted.
     *
     * Positive test
     * @throws InterruptedException
     */
    @Test
    public void deleteOnShopCarL() throws InterruptedException {

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

        //Delete the product
        driver.findElement(By.xpath(String.format(DELETE_PRODUCT_ON_CART_PAGE, "MacBook"))).click();


        //Check is Cart empty
        WebElement alertMessage = driver.findElement(By.xpath("//h1/./following-sibling::p"));
        Assert.assertTrue(alertMessage.getText().contains("Your shopping cart is empty!"));


    }

    /**
     * Test Delete product from dropdown menu
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


        // Click Search Button
        driver.findElement(By.xpath(Search_Button)).click();


        //Add to Cart MacBook
        driver.findElement(By.xpath(String.format(Add_To_Cart_From_Home_Page, "MacBook"))).click();


        //Open Cart by Drop Down Menu
        driver.findElement(By.xpath(DROP_DOWN_CART_BUTTON)).click();

        //Delete product
        driver.findElement(By.xpath(String.format(DELETE_ON_DROPDOWN_MENU,"MacBook"))).click();


        //Open Cart by Drop Down Menu again to check is it empty
        driver.findElement(By.xpath(DROP_DOWN_CART_BUTTON)).click();


        //Check is Cart empty
        WebElement alertMessage = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//p"));
        Assert.assertTrue(alertMessage.getText().contains("Your shopping cart is empty!"));



    }
}