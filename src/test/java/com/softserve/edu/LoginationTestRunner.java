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

public abstract class LoginationTestRunner {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", LoginationTestRunner.class
                .getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(1000); // For Presentation Only
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://192.168.214.128/opencart/upload/");
        Thread.sleep(1000); // For Presentation Only
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        //
        Thread.sleep(1000); // For Presentation Only
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
        //
        Thread.sleep(1000); // For Presentation Only
        //
    }

    protected void login(String login, String password)
            throws InterruptedException {
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        //
        driver.findElement(By.cssSelector(
                ".dropdown-menu.dropdown-menu-right a[href*='account/login']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(login,
                Keys.ARROW_LEFT);
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password,
                Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        //
        Thread.sleep(1000); // For Presentation Only
        //
    }
}
