package com.softserve.edu.opencart.tests.runner;

import java.util.concurrent.TimeUnit;

import com.softserve.edu.opencart.data.UserRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ComponentsPart;
import com.softserve.edu.opencart.pages.user.common.ComponentsTopPart;
import com.softserve.edu.opencart.pages.user.search.SearchCriteriaPart;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class LocalTestRunner {
    
    public final int TWO_HUNDRED_AND_FIFTY_FIVE = 255;
    public final int SIXTY_FIVE_THOUSANDS_FIVE_HUNDRED_AND_THIRTY_SIX = 65536;
    public final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz\\*;.,%$#\\\\'{}()\",";
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String SERVER_URL = "http://192.168.196.129/opencart/upload/";
    protected final String BLOCK_USER_ERROR_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
    }

    public HomePage loadApplication() {
        return new HomePage(driver);
    }

    public SearchCriteriaPart loadSearchCriteriaPart() {
        return new SearchCriteriaPart(driver) {
        };
    }

    public SearchUnsuccessPage loadSearchUnsuccessPage() {
        return new SearchUnsuccessPage(driver);
    }

    public SearchSuccessPage loadSearchSuccessPage() {
        return new SearchSuccessPage(driver);
    }

    public ComponentsTopPart loadComponentsTopPart() {
        return new ComponentsTopPart(driver);
    }

    public ComponentsPart loadComponentsPart() {
        return new ComponentsPart(driver);
    }

    public void presentationSleep(Integer seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
