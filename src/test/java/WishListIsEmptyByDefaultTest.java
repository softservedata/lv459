import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;

/**
 * <h3> This class contains  test which verify if if Wish List is empty by default.</h3>
 *
 * @throws InterruptedException
 */

public class WishListIsEmptyByDefaultTest extends LocalTestRunner {
    /**
     * <h3>This method check if Wish List is empty by default.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void checkWishListIsEmptyByDefault() throws InterruptedException {

        WishListIsEmptyByDefaultTest empty = new WishListIsEmptyByDefaultTest();
        empty.logIn();

        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//*[@id='content']/p"));
        String expected = "Your wish list is empty.";

        Assert.assertEquals(expected, actual.getText());
        Thread.sleep(500);
    }
}