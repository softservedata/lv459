import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SaveAfterLogoutTest  extends LocalTestRunner{

    By wishListField = By.id("wishlist-total");
    By iputEmail = By.id("input-email");
    By iputPassword = By.id("input-password");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By myAccount = By.xpath("//div[@class='container']//div[@id='top-links']//span[@class='caret']");
    By logOut = By.linkText("Logout");
    By logIn = By.linkText("Login");

    @Test
    public void clickDirectlyOnWishList() throws InterruptedException {
        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(500);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(500);

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

        driver.findElement(myAccount).click();
        Thread.sleep(500);

        driver.findElement(logOut).click();
        Thread.sleep(500);

        driver.findElement(myAccount).click();
        Thread.sleep(500);

        driver.findElement(logIn).click();
        Thread.sleep(500);

        driver.findElement(iputEmail).click();
        driver.findElement(iputEmail).clear();
        driver.findElement(iputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(500);

        driver.findElement(iputPassword).click();
        driver.findElement(iputPassword).clear();
        driver.findElement(iputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(iputPassword).submit();
        Thread.sleep(500);

        driver.findElement(wishListField).click();
        Thread.sleep(500);

    }
}