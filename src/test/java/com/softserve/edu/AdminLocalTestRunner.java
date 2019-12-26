package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public abstract class AdminLocalTestRunner {
    protected static WebDriver driver;
    protected final int TWO_SECONDS = 2000;
    protected final int FOUR_SECONDS = 4000;
    protected final String DESCRIPTION = "The Nokia 3310 is a GSM mobile phone announced on 1 September 2000, and released in the fourth quarter of the year, replacing the popular Nokia 3210.";

    /**
     * Before class.
     *
     * @throws Exception exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver", AdminLocalTestRunner.
                class.getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + AdminLocalTestRunner.class.
                getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /**
     * Before method.
     *
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before method");
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    /**
     * After method.
     *
     * @throws Exception exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After method");
    }

    /**
     * After class.
     *
     * @throws Exception exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass");
        driver.quit();
    }
}
