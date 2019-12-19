import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddElementToShoppingCartTest extends LocalTestRunner {

    By wishListField = By.id("wishlist-total");
    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By addToShoppingCart = By.xpath("//div[@class='table-responsive']//button[@class='btn btn-primary']");
    By shoppingCart = By.xpath("//div[@id='cart']//button");

        @Test
        public void checkAddElementToShoppingCart () throws InterruptedException {

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
            Thread.sleep(2000);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0, 500)", "");
            Thread.sleep(2000);

            driver.findElement(By.xpath(String.format(ADD_TO_WISH_LIST_XPATH, "MacBook"))).click();
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0, -500)", "");
            Thread.sleep(2000);
            driver.findElement(wishListField).click();
            Thread.sleep(2000);

            driver.findElement(addToShoppingCart).click();
            Thread.sleep(2000);

            String expected = "Success: You have added MacBook to your shopping cart!";
            WebElement actual = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

            Assert.assertTrue(actual.getText().contains(expected));
            Thread.sleep(2000);

            driver.findElement(shoppingCart).click();
            Thread.sleep(2000);
        }
    }
