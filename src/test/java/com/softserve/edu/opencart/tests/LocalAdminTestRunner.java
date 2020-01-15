package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import com.softserve.edu.opencart.pages.admin.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.softserve.edu.opencart.pages.admin.HomePage;

public abstract class LocalAdminTestRunner {
    private final Long ONE_SECOND_DELAY = 1000L;
    //private final String SERVER_URL = "http://192.168.43.135/opencart/upload/";
    //environment variable
    private final String SERVER_URL = System.getenv().get("OPENCART_URL") + "admin";
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {

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
        driver.get(SERVER_URL);
    }

    @AfterMethod
    public void afterMethod() {
        // TODO Logout
        // driver.get(SERVER_URL);
    }

    public LoginPage loadApplication() {
        return new LoginPage(driver);
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
