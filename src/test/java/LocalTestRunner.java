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
/////////////////////////////////////DONT FORGET TO REMOVE ELEMENTS AFTER TEST PASSED
    protected static WebDriver driver;
    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";
    protected final String REMOVE_FROM_WISH_LIST_BTN = "//td//a[contains(.,'%s')]/../following-sibling::td//i[@class='fa fa-times']";
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


    protected void logIn() throws InterruptedException {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys("bohdanadobushovska@gmail.com");
        Thread.sleep(500);

        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(System.getenv().get("PASSWORD"));
        driver.findElement(inputPassword).submit();
        Thread.sleep(500);
    }

    protected void logOut() throws InterruptedException {
        driver.findElement(myAccount).click();
        Thread.sleep(500);

        driver.findElement(logOut).click();
        Thread.sleep(500);

        driver.findElement(myAccount).click();
        Thread.sleep(500);

        driver.findElement(logIn).click();
        Thread.sleep(500);
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
        public static void tearDownAfterClass() throws Exception {
            System.out.println("@AfterClass");
            Thread.sleep(1000); // For Presentation Only
            driver.quit();
     }

      @Before
        public void setUp() throws Exception {
            System.out.println("\t@Before method");
            driver.get("http://192.168.159.134/opencart/upload/index.php?route=account/login");
            Thread.sleep(1000); // For Presentation Only
            driver.manage().window().maximize();
            Thread.sleep(1000); // For Presentation Only
      }

        @After
        public void tearDown() throws Exception {
            System.out.println("\t@After method");
            //CREATE METHOD FOR REMOVING ITEMS FROM WISH LIST
            // removeAllItems
//            driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "Apple Cinema 30\""))).click();
//            driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "MacBook"))).click();
//            driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "iPhone"))).click();
//            driver.findElement(By.xpath(String.format(REMOVE_FROM_WISH_LIST_BTN, "Canon EOS 5D"))).click();

//            }
            if (isLoggined()) {
                driver.get("http://192.168.159.134/opencart/upload/index.php?route=account/logout");
            }
        }
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

