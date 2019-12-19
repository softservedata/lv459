package com.softserve.edu.uk;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerUk {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass");
        Thread.sleep(1000); // For Presentation Only
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before method");
        driver.get("http://192.168.5.128/opencart/upload/");
        driver.manage().window().maximize();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        Thread.sleep(1000); // For Presentation Only
        // Click login Button
        driver.findElement(By.xpath("//a[contains(@href, 'account/login')]")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Steps
        // Type Login Email
        driver.findElement(By.xpath("//input[@id='input-email']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).clear();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("spirnyak2010@gmail.com");
        Thread.sleep(1000); // For Presentation Only
        //
        // Type Password
        //driver.findElement(By.id("input-password")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).clear();
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(System.getenv().get("OPENCART_PASSWORD"));
        Thread.sleep(1000); // For Presentation Only
        //
        // Click Login Button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
        Thread.sleep(1000); // For Presentation Only
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After method");
        if (isLoggined()) {
            driver.get("http://192.168.5.128/opencart/upload/index.php?route=account/logout");
        }
    }

    private boolean isLoggined() throws Exception {
        List<WebElement> items = null;
        //
        // Click My Account Button
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        // Search Items
        items = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        //
        // Close All Drop-down Menus
        driver.findElement(By.xpath("//input[@name='search']")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        return items.size() > 2;
    }
}