import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

        //Explicit wait must be used instead of thread sleep
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();

        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));
    }
}