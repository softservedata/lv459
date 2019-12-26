import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 *<h3> This class contains test which verify whether the number
 * of added elements are the same to the number of items that are displayed on
 *  the page.</h3>
 */
public class NumberEqualityTest extends LocalTestRunner {
    /**
     * <h3>This method test number equality.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void testNumberEquality() throws InterruptedException {

       NumberEqualityTest equality = new NumberEqualityTest();
       equality.logIn();

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();


         driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        new WebDriverWait(driver, 10)
               .until(ExpectedConditions.textToBe(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"), "Wish List (2)"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(wishListField).click();
        Thread.sleep(1000);// For Presentation Only

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "MacBook"))).click();
        Thread.sleep(1000);// For Presentation Only
        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "iPhone"))).click();
    }
}
