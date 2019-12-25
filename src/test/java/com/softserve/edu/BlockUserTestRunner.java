package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Contains necessary methods and fields for block user tests.
 */
public abstract class BlockUserTestRunner {

    protected static WebDriver driver;

    /**
     * Go to administrator page and login as admin.
     * @throws InterruptedException
     */
    @BeforeClass
    public static void setUpBeforeClass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", BlockUserTestRunner.class
                .getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.214.128/opencart/upload/admin/");
        Thread.sleep(1000); // For Presentation Only
        driver.manage().window().maximize();
        Thread.sleep(1000); // For Presentation Only
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(
                System.getenv().get("OPENCART_ADMIN_LOGIN"), Keys.ARROW_LEFT);
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(
                System.getenv().get("OPENCART_ADMIN_PASSWORD"),
                Keys.ARROW_LEFT);
        driver.findElement(By.id("input-password")).submit();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(
                By.cssSelector(".tile-footer a[href*='route=customer']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
    }

    /**
     * Close ChromeDriver after all tests.
     * @throws InterruptedException
     */
    @AfterClass
    public static void tearDownAfterClass() throws InterruptedException {
        Thread.sleep(1000); // For Presentation Only
        driver.quit();
    }

    /**
     * Logout, if necessary, after each test.
     * @throws InterruptedException
     */
    @After
    public void tearDown() throws InterruptedException {
        switchTabByPartialName("login");
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
            Thread.sleep(1000); // For Presentation Only
        }
        //
        Thread.sleep(1000); // For Presentation Only
    }

    /**
     * Login with specified credentials.
     * @param login    - email to login with.
     * @param password - password to login with.
     * @throws InterruptedException
     */
    protected void login(String login, String password)
            throws InterruptedException {
        driver.get("http://192.168.214.128/opencart/upload");
        //
        Thread.sleep(1000); // For Presentation Only
        //
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
    }

    /**
     * Switch to tab if tab title contains @param login.
     * @param tabName
     */
    protected void switchTabByPartialName(String tabName) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().toLowerCase()
                    .contains(tabName.toLowerCase())) {
                break;
            }
        }
    }

    /**
     * Block/unblock user from administration panel
     * @param status '0' - block user, '1' - unblock user.
     * @throws InterruptedException
     */
    protected void changeUserStatus(String status) throws InterruptedException {
        driver.findElement(By.xpath(String.format(
                "//td[contains(text(), '%s')] /.. /td[@class='text-right'] /a",
                System.getenv().get("OPENCART_LOGIN_TWO")))).click();
        Thread.sleep(2000); // For Presentation Only
        //
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("input-status")))
                .perform();
        Thread.sleep(2000); // For Presentation Only
        //
        Select select = new Select(driver.findElement(By.id("input-status")));
        select.selectByValue(status);
        Thread.sleep(1000); // For Presentation Only
        //
        action.moveToElement(driver.findElement(By.className("fa-save")))
                .perform();
        driver.findElement(By.className("fa-save")).click();
        Thread.sleep(1000); // For Presentation Only
    }
}
