package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains necessary methods and fields for restore password tests.
 */
public abstract class RestorePasswordRunner {

    protected static WebDriver driver;

    /**
     * Switch to tab if tab title contains @param login .
     * @param tabName
     */
    private void switchTabByPartialName(String tabName) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().toLowerCase()
                    .contains(tabName.toLowerCase())) {
                break;
            }
        }
    }

    /**
     * Login with specified credentials.
     * @param username - email to login with.
     * @param password - password to login with.
     * @throws InterruptedException
     */
    protected void login(String username, String password)
            throws InterruptedException {
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(username,
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
        driver.findElement(
                By.cssSelector(".list-unstyled a[href*='account/edit']"))
                .click();
        Thread.sleep(1000); // For Presentation Only
        //
    }

    /**
     * Change password to specified from email restore password letter.
     * @param password - new password for user.
     * @throws InterruptedException
     */
    protected void changePassword(String password) throws InterruptedException {
        driver.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
        //
        driver.findElement(By.cssSelector(
                ".dropdown-menu.dropdown-menu-right a[href*='account/login']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.cssSelector(".form-group a[href*='forgotten']"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(
                System.getenv("OPENCART_LOGIN_RESTORE"), Keys.ARROW_LEFT);
        driver.findElement(By.id("input-email")).submit();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        ((JavascriptExecutor) driver)
                .executeScript("window.open('about:blank','_blank');");
        //
        switchTabByPartialName("about");
        //
        driver.get("https://www.ukr.net/");
        //
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.name("mail widget")));

        WebElement frame = driver.findElement(By.name("mail widget"));
        driver.switchTo().frame(frame);
        if (driver
                .findElements(
                        By.cssSelector(".service__entry.service__entry_mail"))
                .size() == 0) {

            driver.findElement(By.id("id-input-login")).click();
            driver.findElement(By.id("id-input-login")).clear();
            driver.findElement(By.id("id-input-login")).sendKeys(
                    System.getenv("OPENCART_LOGIN_RESTORE"), Keys.ARROW_LEFT);
            //
            Thread.sleep(1000); // For Presentation Only
            //
            driver.findElement(By.id("id-input-password")).click();
            driver.findElement(By.id("id-input-password")).clear();
            driver.findElement(By.id("id-input-password")).sendKeys(
                    System.getenv("OPENCART_ADMIN_PASSWORD"), Keys.ARROW_LEFT);
            driver.findElement(By.id("id-input-password")).submit();
            //
            Thread.sleep(1000); // For Presentation Only
            //
            driver.findElement(
                    By.cssSelector(".service__entry.service__entry_mail"))
                    .click();
            //
        } else {
            driver.findElement(
                    By.cssSelector(".service__entry.service__entry_mail"))
                    .click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000); // For Presentation Only
        //
        switchTabByPartialName("вхідні");
        driver.findElement(By.xpath(
                "//td[@class = 'msglist__row-subject'] /a[contains(text(), 'Password reset')]"))
                .click();
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.cssSelector("#readmsg .readmsg__body a")).click();

        switchTabByPartialName("reset your");
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password,
                Keys.ARROW_LEFT);

        driver.findElement(By.id("input-confirm")).click();
        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm")).sendKeys(password,
                Keys.ARROW_LEFT);
        //
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.cssSelector(".fa.fa-save")).click();
        //
    }

    /**
     * Starting up and configure ChromeDriver before tests.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                RestorePasswordRunner.class
                        .getResource("/chromedriver-windows-32bit.exe")
                        .getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("http://192.168.214.128/opencart/upload/");
        Thread.sleep(1000); // For Presentation Only
    }

    /**
     * Close ChromeDriver after all tests.
     * @throws InterruptedException
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(4000); // For Presentation Only
        driver.quit();
    }

    /**
     * Logout, if necessary, after each test.
     * @throws InterruptedException
     */
    @After
    public void tearDown() throws InterruptedException {
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
    }

}
