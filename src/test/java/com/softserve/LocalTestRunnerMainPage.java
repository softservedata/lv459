package com.softserve;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerMainPage {

    protected static WebDriver driver;
    public static final int DELAY = 1000;

    @BeforeClass
    public static void startDriver() throws Exception {
        System.out.println("@BeforeClass-Start Driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void stopDriver() throws Exception {
        System.out.println("@AfterClass - Stop Driver");
        driver.quit();
    }

    @Before
    public void pageLoad() {
        System.out.println("@Before method - Loading Page");
        driver.get("http://172.16.0.128/opencart/upload/");
    }

    @After
    public void stopPage() {
        System.out.println("@After method - Stop Page");
        if (isLogined()) logOut();
    }

    public boolean isLogined() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        if (driver.findElements(
                By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li"))
                    .size()
            > 2) {
            driver.findElement(By.cssSelector("input[name='search']")).click();
            System.out.println("Customer is LOGINED!");
            return true;
        } else {
            driver.findElement(By.cssSelector("input[name='search']")).click();
            return false;
        }
    }

    protected void logOut() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver
                .findElement(
                        By.cssSelector(
                                "ul.dropdown-menu.dropdown-menu-right > li > " +
                                "a[href*='account/logout']"))
                .click();
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    }
}
