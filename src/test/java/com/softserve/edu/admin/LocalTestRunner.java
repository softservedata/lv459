package com.softserve.edu.admin;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class was implemented to create prerequisites for admin tests.
 */
public abstract class LocalTestRunner {
    /**
     * Driver.
     */
    static WebDriver driver;

    /**
     * Get environment and set implicit waits.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Quit driver after the class.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("@AfterClass");
        driver.quit();
    }

    /**
     * Log in as admin before the tests.
     */
    @Before
    public void setUp() {
        System.out.println("\t@Before method");
        driver.get("http://192.168.5.129/opencart/upload/admin");
        driver.manage().window().maximize();
        //
        // Steps
        // Type Login Username
        driver.findElement(By.xpath("//input[@id='input-username']")).click();
        driver.findElement(By.xpath("//input[@id='input-username']")).clear();
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("admin");
        //
        // Type Password
        //driver.findElement(By.id("input-password")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).clear();
        driver.findElement(By.xpath("//input[@id='input-password']")).
                sendKeys(System.getenv().get("OPENCART_ADMIN_PASSWORD"));
        //
        // Click Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("button-menu")).click();
        driver.findElement(By.id("menu-system")).click();
        driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Localisation')]")).click();
        driver.findElement(By.xpath("//*[@id='menu-system']//li/a[contains(text(), 'Currencies')]")).click();
    }

    /**
     * Delete all cookies.
     */
    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }
}
