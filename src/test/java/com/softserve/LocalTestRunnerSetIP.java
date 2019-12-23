package com.softserve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerSetIP {
    protected static final String IP = "172.16.0.129";
    protected static final int DELAY_FOR_PRESENTATION_ONLY = 1000;
    protected static WebDriver driver;
    protected static final String ADMIN_PANEL_USER = "admin";
    protected static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    protected static final String USER_EMAIL = System.getenv("USER_EMAIL");
    protected static final String USER_PASSWORD = System.getenv("USER_PASSWORD");
    protected static AdminPanel admin = new AdminPanel();

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
}
