import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class NumberEqualityTest extends LocalTestRunner {
    @Test
    public void testNumberEquality() throws InterruptedException {

       NumberEqualityTest equality = new NumberEqualityTest();
       equality.logIn();

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();

        Thread.sleep(1000);
        driver.findElement(wishListField).click();
        Thread.sleep(1000);

        WebElement actual = driver.findElement(By.xpath("//div[@id='top-links']//li/a[@id='wishlist-total']//span"));
        Assert.assertTrue(actual.getText().contains("2"));
        Thread.sleep(1000);

        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "MacBook"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "iPhone"))).click();

    }
}
