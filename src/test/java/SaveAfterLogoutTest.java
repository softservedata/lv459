import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
/**
 * <h3>This class contains method which verify whether products in Wish List are saved after log out.</h3>
 */
public class SaveAfterLogoutTest  extends LocalTestRunner{
    /**
     * <h3>This method check if products are saved after log out.</h3>
     *
     */
    @Test
    public void verifyIfSavedAfterLogOut() throws InterruptedException {

        SaveAfterLogoutTest saveAfterLogoutTest = new SaveAfterLogoutTest();
        saveAfterLogoutTest.logIn();

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "Canon EOS 5D"))).click();

        //Explicit wait must be used instead of thread sleep
        Thread.sleep(2000);// For Presentation Only
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();

        jse.executeScript("window.scrollBy(0, -500)", "");

        driver.findElement(wishListField).click();

        saveAfterLogoutTest.logOut();
        saveAfterLogoutTest.logIn();

        driver.findElement(wishListField).click();

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));

    }
}