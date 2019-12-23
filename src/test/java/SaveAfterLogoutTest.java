import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SaveAfterLogoutTest  extends LocalTestRunner{

    @Test
    public void clickDirectlyOnWishList() throws InterruptedException {

        SaveAfterLogoutTest saveAfterLogoutTest = new SaveAfterLogoutTest();
        saveAfterLogoutTest.logIn();

        driver.findElement(openCartField).click();
        Thread.sleep(500);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(500);

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "Canon EOS 5D"))).click();
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();
        Thread.sleep(500);

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(500);

        driver.findElement(wishListField).click();
        Thread.sleep(500);

        saveAfterLogoutTest.logOut();

        saveAfterLogoutTest.logIn();

        driver.findElement(wishListField).click();
        Thread.sleep(500);

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));

        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "Canon EOS 5D"))).click();
        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "iPhone"))).click();
    }
}