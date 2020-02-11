package com.softserve.edu.opencart.tests.runner;

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

public abstract class LocalAdminRunner extends Runner {



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
