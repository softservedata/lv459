package LoginUser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner {
    public static WebDriver driver;
    protected static String IP = "192.168.234.129";

    /**
     * Before all tests we should
     *
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver",
                AddingQuickLTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

    @Before
    public void setUp() throws Exception{
        driver.get(String.format("http://%s/opencart/upload/index.php?route=common/home", IP));
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        loginUser();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        // We can use method deleteAllCookies() to Logout, but it's not the best practice.
        //driver.manage().deleteAllCookies();
        //
        //Method check if we are logged we should Logout.
        if (isLoggined()) {
            driver.get(String.format("http://%s/opencart/upload/index.php?route=account/logout", IP));
        }
    }

    /*
     * Method Login the User.
     */

    public void loginUser() throws InterruptedException {
        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Login")).click();
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("user1@gmail.com");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("password"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).submit();
    }

    /*
    Method check how many items in dropdown-menu in My Account
    * if they more than 2 we should Logout.
    * */
    private boolean isLoggined() throws Exception {
        List<WebElement> items = null;
        //
        // Click My Account Button
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Search Items
        items = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        //
        // Close All Drop-down Menus
        driver.findElement(By.xpath("//input[@name='search']")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        return items.size() > 2;
    }
}
