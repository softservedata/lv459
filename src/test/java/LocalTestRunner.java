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
    protected static WebDriver driver;
    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";

    By inputEmail = By.id("input-email");
    By inputPassword = By.id("input-password");
    By removeButton = By.xpath("//table[@class='table table-bordered table-hover']//a//i");

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

//CREATE METHOD FOR REMOVING ITEMS FROM WISH LIST

    /*protected void removeAllItems() {
        List<WebElement> removeProductBtnList = driver.findElements(removeButton);
        for (WebElement webElement : removeProductBtnList)
            driver.findElement(removeButton).click();
    }*/

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
            if (isLoggined()) {
                driver.get("http://10.26.34.200/opencart/upload/index.php?route=account/logout");
            }
        }

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

