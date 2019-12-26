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
     * @throws InterruptedException
     */
    @Test
    public void verifyIfSavedAfterLogOut() throws InterruptedException {

        SaveAfterLogoutTest saveAfterLogoutTest = new SaveAfterLogoutTest();
        saveAfterLogoutTest.logIn();

        driver.findElement(openCartField).click();
        Thread.sleep(500);// For Presentation Only

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(500);// For Presentation Only

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "Canon EOS 5D"))).click();
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();
        Thread.sleep(500);// For Presentation Only

        jse.executeScript("window.scrollBy(0, -500)", "");
       Thread.sleep(500);// For Presentation Only

        driver.findElement(wishListField).click();
        Thread.sleep(500);// For Presentation Only

        saveAfterLogoutTest.logOut();
        saveAfterLogoutTest.logIn();

        driver.findElement(wishListField).click();
       Thread.sleep(500);// For Presentation Only

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));

    }
}