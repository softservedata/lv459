package com.softserve.edu.opencart.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class LocalAdminSingleThreadRunner extends LocalAdminRunner {

    @BeforeClass
    public void beforeClass(ITestContext context) {

        // For single thread driver

        //                WebDriverManager.firefoxdriver().setup();
        //                FirefoxOptions options = new FirefoxOptions ();
        //        driver = new FirefoxDriver(options);
        //                        options.addArguments("start-maximized");
        //                        options.addArguments("--headless");
        //
        //
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //        options.addArguments("start-maximized");
        //        options.addArguments("--headless");

        //        options.addArguments("--no-sandbox");
        //        options.addArguments("--disable-setuid-sandbox");
        //        options.addArguments("enable-automation");
        //        options.addArguments("--disable-extensions");
        //        options.addArguments("--disable-gpu");
        //        options.addArguments("--disable-infobars");
        //        options.addArguments("--disable-dev-shm-usage");
        //        options.addArguments("--remote-debugging-port=9222");
        //        options.addArguments("--disable-browser-side-navigation");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

}
