import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
/**
 * <h3> This class contains all necessary method and fields to run test when user are not logged in the system.</h3>
 */
public abstract class NotLogInTestRunner {
    protected static WebDriver driver;
    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";

    /**
     * <h3>This is BeforeClass method in which the webdriver is ran and new ChromeDriver is made for all tests.</h3>
     *
     */
    @BeforeClass
    public static void setUpBeforeClass()  {
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
     **/
    @AfterClass
    public static void tearDownAfterClass() {
        driver.quit();
    }

    /**
     * <h3>This is Before method in  which the login page is opening.</h3>
     *
     */
    @Before
    public void setUp() {
        System.out.println("\t@Before method");
        driver.get("http://192.168.159.135/opencart/upload/index.php?route=common/home");
        driver.manage().window().maximize();
    }
}

