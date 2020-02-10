package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class LocalAdminSingleThreadRunner {

    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
//    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
        private final String SERVER_URL = ("http://172.16.0.131/opencart/upload/");
    private final String SERVER_ADMIN_URL = SERVER_URL + "admin/";
    protected final String USER_ENABLED = "1";
    protected final String USER_DISABLED = "0";
    protected final String EXPECTED_ERROR_MESSAGE =
            "Warning: No match for E-Mail Address and/or Password.";
    protected final String CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE =
            "Your Account Has Been Created!";
    protected final String CUSTOMER_FIRSTNAME_ERROR =
            "First Name must be between 1 and 32 characters!";
    protected final String FIRST_NAME_AMEND = "Lv459-TAQC-Updated";
    protected final String CUSTOMER_UPDATED_MESSAGE =
            "Success: Your account has been successfully updated.";
    private WebDriver driver; // singlethread

//    @BeforeSuite
//
//    @AfterSuite

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

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod working.");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            System.out.println("***Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report,
            // Return to takePageSource(takeScreenShot());
            // TODO take screenshot
        }
    }

    public LoginPage loadAdminPage() {
        System.out.println("SERVER_ADMIN_URL: " + SERVER_ADMIN_URL);
        driver.get(SERVER_ADMIN_URL); // single thread driver
        return new LoginPage(driver); // single thread driver
    }

    public HomePage loadMainPage() {
        System.out.println("server url = " + SERVER_URL);
        driver.get(SERVER_URL); // single thread driver
        return new HomePage(driver); // single thread driver
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
