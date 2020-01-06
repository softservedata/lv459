import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class NotLoggedInUserClickAddToWishListTest extends NotLogInTestRunner {
    /**
     * <h3>This verify what is going on when user is not logged in
     * system and try to add product to Wish List.</h3>
     */
    @Test
    public void verifyNotLoggedInUserClickAddToWishList() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();

        WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String expected = "You must login or create an account to save MacBook to your wish list!";

        Assert.assertTrue(expected, actual.getText().contains(expected));
    }
}
