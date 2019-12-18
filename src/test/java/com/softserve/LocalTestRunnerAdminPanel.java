package com.softserve;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerAdminPanel {
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
    public void pageLoad() throws Exception{
        System.out.println("@Before method - Loading Page");
        driver.get("http://172.16.0.128/opencart/upload/admin/");

        // Login as admin
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("admin");

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(System.getenv("DB_PASSWORD"));

        Thread.sleep(DELAY);

        driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);
    }

    @After
    public void stopPage() {
        System.out.println("@After method - Log out");
        driver.findElement(By.cssSelector("a[href*='common/logout']"));

    }
}
