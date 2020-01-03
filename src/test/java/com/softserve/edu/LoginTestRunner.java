package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains necessary methods and fields for login tests.
 */
public abstract class LoginTestRunner {

    protected static WebDriver driver;

    /**
     * Starting up and configure ChromeDriver before tests.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", LoginTestRunner.class
                .getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Close ChromeDriver after all tests.
     * @throws InterruptedException
     */
    @AfterClass
    public static void tearDownAfterClass() throws InterruptedException {
        driver.quit();
    }

    /**
     * Open main page before each test.
     * @throws InterruptedException
     */
    @Before
    public void setUp() throws InterruptedException {
        driver.get("http://192.168.214.130/opencart/upload/");
    }

    /**
     * Logout, if necessary, after each test.
     * @throws InterruptedException
     */
    @After
    public void tearDown() throws InterruptedException {
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        //
        if (driver
                .findElements(
                        By.cssSelector(".dropdown-menu.dropdown-menu-right li"))
                .size() > 2) {
            driver.findElement(By.cssSelector(
                    ".dropdown-menu.dropdown-menu-right a[href*='account/logout']"))
                    .click();
            driver.findElement(By.name("search")).click();
        }
    }

    /**
     * Login with specified credentials.
     * @param login    - email to login with.
     * @param password - password to login with.
     * @throws InterruptedException
     */
    protected void login(String login, String password)
            throws InterruptedException {
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        //
        driver.findElement(By.cssSelector(
                ".dropdown-menu.dropdown-menu-right a[href*='account/login']"))
                .click();
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(login,
                Keys.ARROW_LEFT);
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password,
                Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
    }
}
