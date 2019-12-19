import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner {
    protected static WebDriver driver;
    protected final String ADD_TO_WISH_LIST_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'wishlist.add')]";

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
            driver.get("http://192.168.159.132/opencart/upload/index.php?route=account/login");
            Thread.sleep(1000); // For Presentation Only
            driver.manage().window().maximize();
            Thread.sleep(1000); // For Presentation Only
      }

        @After
        public void tearDown() throws Exception {
            System.out.println("\t@After method");
//            if (isLoggined()) {
//                driver.get("http://10.26.34.200/opencart/upload/index.php?route=account/logout");
//            }
        }
    }

