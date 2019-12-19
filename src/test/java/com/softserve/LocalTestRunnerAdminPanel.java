package com.softserve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerAdminPanel extends LocalTestRunnerSetIp{

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
    public void pageLoad() throws Exception{
        System.out.println("@Before method - Loading Page");
        driver.get(String.format("http://%s/opencart/upload/admin/", IP));

        // Login as admin
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("admin");

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(DB_PASSWORD);

        Thread.sleep(DELAY);

        driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);
    }

    @After
    public void stopPage() {
        System.out.println("@After method - Log out");
        driver.findElement(By.cssSelector("a[href*='common/logout']"));

    }
}
