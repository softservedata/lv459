import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
/**
 * <h3> This class contains two methods which verify if buttons in Wish List work.</h3>
 */
public class VerifyButtonsInWishListTest extends LocalTestRunner { /**
 *
 * <h3>This method check if button 'Add to shopping cart' works.</h3>
 *
 * @throws InterruptedException
 */
    @Test
    public void addElementToShoppingCart() throws InterruptedException {

        VerifyButtonsInWishListTest addElement = new VerifyButtonsInWishListTest();
        addElement.logIn();

        driver.findElement(openCartField).click();
        Thread.sleep(1000);// For Presentation Only

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "iPhone"))).click();
        Thread.sleep(1000);// For Presentation Only

        jse.executeScript("window.scrollBy(0, -500)", "");
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(wishListField).click();
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.xpath(String.format(ADD_TO_SHOPPING_CART_BTN, "iPhone"))).click();
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(shoppingCartBtn).click();
         Thread.sleep(1000);// For Presentation Only

        String expected = "iPhone";
        WebElement actual = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']"));

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "iPhone"))).click();
    }

    /**
     * <h3>This method check if button 'Remove from Wish List' works.</h3>
     *
     * @throws InterruptedException
     */
    @Test
    public void removeElementFromWishList() throws InterruptedException { //ПРАЦЮЄ ЧЕРЕЗ РАЗ!!!!????????

        VerifyButtonsInWishListTest removeElement = new VerifyButtonsInWishListTest();
        removeElement.logIn();

        driver.findElement(openCartField).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)", "");

        driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "Apple Cinema 30\""))).click();
        Thread.sleep(1000);// For Presentation Only

        jse.executeScript("window.scrollBy(0, -500)", "");

        driver.findElement(wishListField).click();
        Thread.sleep(1000);// For Presentation Only

        driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "Apple Cinema 30\""))).click();

        WebElement actual = driver.findElement(By.xpath("//div[contains(text(), ' Success: You have modified your wish list!')]"));
        String expected = "Success: You have modified your wish list!";

        Assert.assertTrue(actual.getText().contains(expected));
        Thread.sleep(1000);// For Presentation Only
    }
}
