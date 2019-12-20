package LoginUser;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.awt.*;


public class WrongAddWithOptionsL extends LocalTestRunner{
    private final String Search_Field = "//input[@name='search']";
    private final String Search_Button = "//button[@class='btn btn-default btn-lg']";
    private final String ADD_TO_CART_BY_STARTS_WITH = "//a[starts-with(.,'%s')]/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
    private final String CHOOSE_RADIO_BUTTON = "//div[@id='product']//div[@class='radio']/label[text()[contains(., '%s')]]";
    private final String CHOOSE_CHECKBOX_BUTTON = "//div[@id='product']//div[@class='checkbox']/label[text()[contains(., '%s')]]";
    private final String SELECT_OPTIONS = "//option[starts-with(.,'%s')]";
    private final String INPUT_DATE = "//div[@class='input-group date']/input";
    private final String INPUT_TIME = "//div[@class='input-group time']/input";
    private final String INPUT_DATETIME = "//div[@class='input-group datetime']/input";

    /**
     * Method should check that product are not added to cart
     * cause not all necessary options was chosen.
     *
     * Negative test
     * @throws InterruptedException
     * @throws AWTException
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

        //Check by message does product are not added to Cart cause we didn't select all options.
        WebElement alertMessage = driver.findElement(By.xpath("//input[contains(@id,'input-option222')]/./following-sibling::div"));
        org.junit.Assert.assertTrue(alertMessage.getText().contains("File required!"));
        Thread.sleep(1000);
    }


}
