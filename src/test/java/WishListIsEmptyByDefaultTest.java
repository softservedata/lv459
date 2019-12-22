import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;

public class WishListIsEmptyByDefaultTest  extends LocalTestRunner{
    @Test
    public void checkWishListIsEmptyByDefault() throws InterruptedException {

        WishListIsEmptyByDefaultTest empty = new WishListIsEmptyByDefaultTest();
        empty.logIn();

        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//*[@id=\"content\"]/p"));
        String expected = "Your wish list is empty.";

        Assert.assertEquals(expected, actual.getText());
        Thread.sleep(500);
    }
}