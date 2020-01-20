package com.softserve.edu.opencart.tests.currency;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestRunner {

    final String CURRENCY_PATTERN = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
    final String MAC_BOOK_TAX_PRICE = "602.00";
    final String MAC_BOOK_NO_TAX_PRICE = "500.00";
    final String MAC_BOOK_TAX_PRICE_POUND = "368.73";
    final String MAC_BOOK_NO_TAX_PRICE_POUND = "306.25";
    final String MAC_BOOK = "MacBook";

    private final Long ONE_SECOND_DELAY = 1000L;
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
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
            loadApplication().gotoMyAccount().gotoEditAccountRight().clickLogoutRight();
        }
        driver.manage().deleteAllCookies();
    }

    public HomePage loadApplication() {
        return new HomePage(driver);
    }

    public void presentationSleep() {
        presentationSleep(1);
    }

    public void presentationSleep(Integer seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}