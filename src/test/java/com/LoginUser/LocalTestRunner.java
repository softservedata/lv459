package com.LoginUser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner {
    public static WebDriver driver;
    protected static String IP = "192.168.234.132";
    private final String DROP_DOWN_CART_BUTTON = "//span[@id='cart-total']";

    /**
     * Before all tests browser should open.
     * Here specified implicit Wait
     *
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * After all tests browser should close.
     * @throws Exception
     */

    @AfterClass
    public static void tearDownAfterClass() throws Exception{

        driver.quit();
    }

    /**
     * Before each test OpenCart site should open on Home Page
     * Window should be opened to full screen.
     * User must be logged.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        driver.get(String.format("http://%s/opencart/upload/index.php?route=common/home", IP));
        driver.manage().window().maximize();
        loginUser();
    }

    @After
    public void tearDown() throws Exception{
        //Open Cart by Drop Down Menu
        driver.findElement(By.xpath(DROP_DOWN_CART_BUTTON)).click();


        // Delete all product from cart,
        // cause we need to clean cart after each test

        cleanCart();
        /*We can use method deleteAllCookies() to Logout, but it's not the best practice.
        driver.manage().deleteAllCookies();*/

        //Method check if we are logged we should Logout.
        if (isLogged()) {
            driver.get(String.format("http://%s/opencart/upload/index.php?route=account/logout", IP));
        }
    }

    /**
     * A separate Method that is responsible for login the User.
     */

    public void loginUser() throws InterruptedException {
        driver.findElement(By.className("dropdown")).click();
        //Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Login")).click();
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("user1@gmail.com");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("PASSWORD"));

        driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).submit();
    }

    /*
    Method check how many items in dropdown-menu in My Account
    * if they more than 2 we should Logout.
    * */
    private boolean isLogged() throws Exception {
        List<WebElement> items = null;
        //
        // Click My Account Button
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        // Search Items
        items = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        //
        // Close All Drop-down Menus
        driver.findElement(By.xpath("//input[@name='search']")).click();
        //Thread.sleep(1000); // For Presentation Only
        //
        return items.size() > 2;
    }

    public void cleanCart(){

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> closeButtons = driver.findElements(By.cssSelector(".fa.fa-times"));
        while (closeButtons.size() > 0){

            closeButtons.get(0).click();
            (new WebDriverWait(driver,10)).until(ExpectedConditions.stalenessOf(closeButtons.get(0)));

            closeButtons = driver.findElements(By.cssSelector(".fa.fa-times"));
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
