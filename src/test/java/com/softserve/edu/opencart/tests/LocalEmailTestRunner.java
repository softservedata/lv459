package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.ukrNet.MainEmailPage;

public class LocalEmailTestRunner {

    private final String EMAIL_URL = "https://www.ukr.net/";
    protected final String RESET_PASSWORD_MESSAGE = "Password reset";
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    private static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("enable-automation");
//        options.addArguments("--no-sandbox");
////        options.addArguments("--headless");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-gpu");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        System.out.println("PATH: " + LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(SERVER_URL);
    }
    
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (ApplicationStatus.get().isLogged()) {
            driver.get(SERVER_URL);
            loadApplication()
            .gotoMyAccount()
            .gotoEditAccountRight()
            .clickLogoutRight();
        }
    }

    public HomePage loadApplication() {
        return new HomePage(driver);
    }
    
    public MainEmailPage loadEmailPage() {
        driver.get(EMAIL_URL);
        return new MainEmailPage(driver);
    }
}
