package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class LocalAdminRunner {

    protected final Long ONE_SECOND_DELAY = 1000L;
    protected final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    //    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    protected final String SERVER_URL =
            ("http://192.168.196.129/opencart/upload/");
    protected final String SERVER_ADMIN_URL = SERVER_URL + "admin/";
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
    protected final String HRYVNIA = "hryvnia";
    protected WebDriver driver; // singlethread
    protected Map<Long, WebDriver> drivers; // multithread

    //    @BeforeSuite
    //
    //    @AfterSuite

    @BeforeClass
    public void beforeClass(ITestContext context) {


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

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

}
