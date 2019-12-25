package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public abstract class LocalTestRunner {
    protected static WebDriver driver;
    protected final int TWO_SECONDS = 2000;
    protected final int FOUR_SECONDS = 4000;
    protected final String SEARCH_FIELD = "search";
    protected final String SEARCH_BUTTON = "button.btn.btn-default.btn-lg";
    protected final String HOME_PAGE = "#logo .img-responsive";
    protected final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz";



    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before method");
        driver.get("http://192.168.216.128/opencart/upload/");
        //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After method");
        // Returning to the previous state
        driver.findElement(By.cssSelector(HOME_PAGE)).click();
        Thread.sleep(TWO_SECONDS); // For Presentation Only
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass");
        //Thread.sleep(1000); // For Presentation Only
        driver.quit();
    }
}
