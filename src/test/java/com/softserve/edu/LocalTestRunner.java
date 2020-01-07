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
    protected final int THREE_SECONDS = 3000;
    protected final int FOUR_SECONDS = 4000;
    protected final String SEARCH_FIELD = "search";
    protected final String SEARCH_CRITERIA_FIELD = "input-search";
    protected final String SEARCH_BUTTON = "button.btn.btn-default.btn-lg";
    protected final String HOME_PAGE = "#logo .img-responsive";
    protected final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz\\*;.,%$#\\\\'{}()\",";
    protected final String CATEGORY_DROP_DOWN_LIST = "category_id";
    protected final String SEARCH_IN_SUBCATEGORIES_CHECKBOX = "//input[@name='sub_category']";
    protected final String SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX = "//input[@name='description']";
    protected final String SEARCH_CRITERIA_BUTTON = "button-search";
    protected final String COMPONENTS_TAB_ON_THE_NAVIGATION_BAR = "//nav[@id='menu']//li[@class='dropdown']/a[contains(.,'Components')]";
    protected final int TWO_HUNDRED_AND_FIFTY_FIVE = 255;
    protected final int SIXTY_FIVE_THOUSANDS_FIVE_HUNDRED_AND_THIRTY_SIX = 65536;

    /**
     * Before class.
     *
     * @throws Exception exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver", LocalTestRunner.class
                .getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + LocalTestRunner.class
                .getResource("/chromedriver-windows-32bit.exe").getPath());
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
        driver.get("http://192.168.216.128/opencart/upload/");
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
        // Returning to the previous state
        driver.findElement(By.cssSelector(HOME_PAGE)).click();
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
