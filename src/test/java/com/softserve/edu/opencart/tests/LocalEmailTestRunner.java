package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.ukrNet.MainEmailPage;

public class LocalEmailTestRunner {

    private final String EMAIL_URL = "https://www.ukr.net/";
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    private static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

    public HomePage loadApplication() {
        return new HomePage(driver);
    }
    
    public MainEmailPage loadEmailPage() {
        driver.get(EMAIL_URL);
        return new MainEmailPage(driver);
    }
}
