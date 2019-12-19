package com.softserve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerMainPage extends LocalTestRunnerSetIp {

    @BeforeClass
    public static void startDriver() throws Exception {
        System.out.println("@BeforeClass-Start Driver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

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
        driver.get(String.format("http://%s/opencart/upload/", IP));
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
