package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AdminTestRunner {
    
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String SERVER_ADMIN_URL = System.getenv().get("OPENCART_URL") + "admin";
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    protected final String HRYVNIA = "hryvnia";
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(SERVER_ADMIN_URL);
    }

    @AfterMethod
    public void afterMethod() {
        // TODO Logout
        // driver.get(SERVER_URL);
    }

    public LoginPage loadAdminPage() {
        return new LoginPage(driver);
    }

    public HomePage loadmainPage() {
        driver.get(SERVER_URL);
        return new HomePage(driver);
    }

    public void presentationSleep() {
        presentationSleep(1);
    }

    public void presentationSleep(Integer seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}