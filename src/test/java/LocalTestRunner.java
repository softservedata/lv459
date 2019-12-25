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

/**
 * <h3> This class contains all necessary method and fields to run tests.</h3>
 */
public abstract class LocalTestRunner {

    protected static WebDriver driver;
    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";
    protected final String REMOVE_FROM_WISH_LIST_BTN = "//td//a[contains(.,'%s')]/../following-sibling::td//a[@class='btn btn-danger']/i[@class='fa fa-times']";
    protected final String ADD_TO_SHOPPING_CART_BTN = "//td//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-shopping-cart']";

    By wishListField = By.id("wishlist-total");
    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By myAccount = By.xpath("//div[@class='container']//div[@id='top-links']//span[@class='caret']");
    By logOut = By.linkText("Logout");
    By logIn = By.linkText("Login");
    By openCartField = By.xpath("//*[@id=\"logo\"]/a/img");
    By footerWishList = By.linkText("Wish List");
    By searchField = By.name("search");
    By productAppleCinema = By.linkText("Apple Cinema 30\"");
    By heartButton = By.xpath("//div[@id='content']//div[@class='col-sm-4']//button[contains(@onclick, 'wishlist.add')]");
    By shoppingCartBtn = By.xpath("//div[@id='cart']//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");

    /**
     * <h3>This method is made to login in the system.</h3>
     *
     * @throws InterruptedException
     */
    protected void logIn() throws InterruptedException {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(500);// For Presentation Only

        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(inputPassword).submit();
        Thread.sleep(500);// For Presentation Only
    }

    /**
     * <h3>This method is made to logout from the system.</h3>
     *
     * @throws InterruptedException
     */

    protected void logOut() throws InterruptedException {
        driver.findElement(myAccount).click();
        Thread.sleep(500);// For Presentation Only

        driver.findElement(logOut).click();
        Thread.sleep(500);// For Presentation Only

        driver.findElement(myAccount).click();
        Thread.sleep(500);// For Presentation Only

        driver.findElement(logIn).click();
        Thread.sleep(500);// For Presentation Only
    }

    /**
     * <h3>This is BeforeClass method in which the webdriver is ran and new ChromeDriver is made for all tests.</h3>
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * <h3>This is AfterClass method which close the browser for all methods.</h3>
     *
     * @throws Exception
     */
    @AfterClass
        public static void tearDownAfterClass() throws Exception {
        Thread.sleep(1000);
        driver.quit();
     }

    /**
     * <h3>This is Before method in  which the login page is opening.</h3>
     *
     * @throws Exception
     */
      @Before
        public void setUp() throws Exception {
            driver.get("http://192.168.159.136/opencart/upload/index.php?route=account/login");
            Thread.sleep(1000); // For Presentation Only
            driver.manage().window().maximize();
            Thread.sleep(1000); // For Presentation Only
      }

    /**
     * <h3>This is After method  which logout user.</h3>
     *
     * @throws Exception
     */
        @After
        public void tearDown() throws Exception {
            if (isLoggined()) {
                driver.get("http://192.168.159.136/opencart/upload/index.php?route=account/logout");
            }
        }

    /**
     * <h3>This is method which verify is user is logged in.</h3>
     *
     * @throws Exception
     */
    private boolean isLoggined() throws Exception {

        List<WebElement> items = null;
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        Thread.sleep(1000); // For Presentation Only

        items = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));

        driver.findElement(By.xpath("//input[@name='search']")).click();
        Thread.sleep(1000); // For Presentation Only

        return items.size() > 2;
    }
}

