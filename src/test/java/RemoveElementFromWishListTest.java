import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RemoveElementFromWishListTest extends LocalTestRunner {

    By wishListField = By.id("wishlist-total");
    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By removeButton = By.xpath("//table[@class='table table-bordered table-hover']//a//i");

    @Test
    public void checkRemoveElementFromWishList() throws InterruptedException {

        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(2000);

        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(inputPassword).submit();
        Thread.sleep(2000);

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0, -500)", "");
        driver.findElement(wishListField).click();
        Thread.sleep(2000);

        driver.findElement(removeButton).click();

       WebElement actual = driver.findElement(By.xpath("//div[contains(text(), ' Success: You have modified your wish list!')]"));
        String expected = "Success: You have modified your wish list!";

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(2000);

    }
}
