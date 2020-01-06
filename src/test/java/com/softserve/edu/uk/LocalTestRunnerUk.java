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

/**
 * This class was implemented to create prerequisites for user with taxes tests.
 */
public abstract class LocalTestRunnerUk {
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
     * Log in as user before the tests.
     */
    @Before
    public void setUp() {
        System.out.println("\t@Before method");
        driver.get("http://192.168.5.129/opencart/upload/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        // Click login Button
        driver.findElement(By.xpath("//a[contains(@href, 'account/login')]")).click();
        //
        // Steps
        // Type Login Email
        driver.findElement(By.xpath("//input[@id='input-email']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).clear();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("spirnyak2010@gmail.com");
        //
        // Type Password
        //driver.findElement(By.id("input-password")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).clear();
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys
                (System.getenv().get("OPENCART_PASSWORD"));
        //
        // Click Login Button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
    }

    /**
     * Delete used items during tests.
     */
    @After
    public void tearDown() {
        System.out.println("\t@After method");
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
        checkCart();
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
        //checkWishList();
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
        if (isLoggined()) {
            driver.get("http://192.168.5.129/opencart/upload/index.php?route=account/logout");
        }
        driver.manage().deleteAllCookies();
    }

    /**
     * This method was implemented in order to check if the user is logged out.
     *
     * @return the amount of div containers to decide if we have to log out.
     */
    private boolean isLoggined() {
        List<WebElement> items = null;
        //
        // Click My Account Button
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        //
        // Search Items
        items = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        //
        // Close All Drop-down Menus
        driver.findElement(By.xpath("//input[@name='search']")).click();
        //
        return items.size() > 2;
    }

    /**
     * This method was implemented to clear the cart after the test.
     */
    private void checkCart() {
        WebElement itemsAmount = driver.findElement(By.xpath("//*[@id='cart']//span"));
        if (!itemsAmount.getText().contains("0 item(s)")) {
            driver.findElement(By.xpath("//*[@id='cart']/button")).click();
            List<WebElement> closeButtons = driver.findElements(By.xpath("//*[@id='cart']//" +
                    "table[@class='table table-striped']/tbody/tr/td[@class='text-center']/button"));
            for (WebElement current : closeButtons) {
                current.click();
                driver.findElement(By.xpath("//*[@id='cart']/button")).click();
            }
        }

    }
}
