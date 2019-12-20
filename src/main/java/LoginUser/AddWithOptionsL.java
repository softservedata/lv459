package LoginUser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class AddWithOptionsL extends LocalTestRunner {
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String ADD_TO_CART_BY_STARTS_WITH = "//a[starts-with(.,'%s')]/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String CHOOSE_RADIO_BUTTON = "//div[@id='product']//div[@class='radio']/label[text()[contains(., '%s')]]";
    private final String CHOOSE_CHECKBOX_BUTTON = "//div[@id='product']//div[@class='checkbox']/label[text()[contains(., '%s')]]";
    private final String SELECT_OPTIONS = "//option[starts-with(.,'%s')]";
    private final String INPUT_DATE = "//div[@class='input-group date']/input";
    private final String INPUT_TIME = "//div[@class='input-group time']/input";
    private final String INPUT_DATETIME = "//div[@class='input-group datetime']/input";
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";
    private final String DELETE_ON_DROPDOWN_MENU = "//table[@class='table table-striped']//tbody//tr//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";


    /**
     * Method where we add Apple Cinema - the product which we can add to cart chosen the special
     * options previously.
     *
     *Positive test
     * @throws InterruptedException for Thread.sleep.
     * @throws AWTException for Robot.
     */
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
        //Choose radio button which contains text "Large"
        driver.findElement(By.xpath(String.format(CHOOSE_RADIO_BUTTON, "Large"))).click();

        //Choose two Checkboxes
        driver.findElement(By.xpath(String.format(CHOOSE_CHECKBOX_BUTTON, "Checkbox 1"))).click();
        driver.findElement(By.xpath(String.format(CHOOSE_CHECKBOX_BUTTON, "Checkbox 3"))).click();

        //Type Text to text-field
        driver.findElement(By.xpath("//input[@placeholder='Text']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Text']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Text']")).sendKeys("test");

        //Open Select
        driver.findElement(By.xpath("//select")).click();
        Thread.sleep(1000);

        // Select options
        driver.findElement(By.xpath(String.format(SELECT_OPTIONS, "Yellow"))).click();
        Thread.sleep(1000);

        //Type text in TextArea
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).clear();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).sendKeys("Text");

        /*
        Here I use Robot class to control keyboard or mouse
        to interact with OS Windows.
        */
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
        Thread.sleep(1000);

        /*
            I can use this way to upload file. If I know that Upload button work correctly
            I can put file's control sum to input attribute 'value'. But it is can be
            used even when we tested it before and know value exactly.

        WebElement uploadInput = driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                uploadInput, "value", "fee9e81729574a48e990d2a6fcfd01c98be0c8e7");*/

        // Type Date
        driver.findElement(By.xpath(INPUT_DATE)).click();
        driver.findElement(By.xpath(INPUT_DATE)).clear();
        driver.findElement(By.xpath(INPUT_DATE)).sendKeys("2019-12-27");
        Thread.sleep(1000);

        // Type Time
        driver.findElement(By.xpath(INPUT_TIME)).click();
        driver.findElement(By.xpath(INPUT_TIME)).clear();
        driver.findElement(By.xpath(INPUT_TIME)).sendKeys("10:50");
        Thread.sleep(1000);

        // Type Date-Time
        driver.findElement(By.xpath(INPUT_DATETIME)).click();
        driver.findElement(By.xpath(INPUT_DATETIME)).clear();
        driver.findElement(By.xpath(INPUT_DATETIME)).sendKeys("2019-12-27 10:50");
        Thread.sleep(1000);

        // Type quantity
        driver.findElement(By.id("input-quantity")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("3");
        Thread.sleep(1000);

        // Click Add to Cart Button
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(10000);

        //Check by message does product successfully are added to Cart.
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
