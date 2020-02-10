package com.softserve.edu.opencart.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.ITestContext;

import org.testng.annotations.*;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class LocalAdminTestRunner {

    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    private final String SERVER_ADMIN_URL = SERVER_URL + "admin/";
    protected final String USER_ENABLED = "1";
    protected final String USER_DISABLED = "0";
    protected final String EXPECTED_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
    protected final String CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE = "Your Account Has Been Created!";
    protected final String CUSTOMER_FIRSTNAME_ERROR = "First Name must be between 1 and 32 characters!";
    protected final String FIRST_NAME_AMEND = "Lv459-TAQC-Updated";
    protected final String CUSTOMER_UPDATED_MESSAGE = "Success: Your account has been successfully updated.";
//    private Map<Long, WebDriver> drivers; // multithread
    private WebDriver driver; // singlethread

    @BeforeSuite
//    public void beforeSuit (){
//        drivers = new HashMap<>();
//    }

    @AfterSuite
//    public void afterSuit(){
//        drivers=null;
//    }

    @BeforeClass
    public void beforeClass(ITestContext context) {

        // For singlethread driver
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options = new FirefoxOptions ();
        options.addArguments("start-maximized");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-setuid-sandbox");
//        options.addArguments("--headless");
//        options.addArguments("enable-automation");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
//        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
//        options.addArguments("--remote-debugging-port=9222");
//        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        driver = new FirefoxDriver(options);
//        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Multithread drivers
//            for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
//                System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
//                if (entry.getKey().toLowerCase().equals("url")) {
//                    serverUrl = entry.getValue();
//                    break;
//                }
//            }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // for only single thread driver
        if (driver != null) {
        	driver.quit();
        }

        // closes driver if running in multi thread
//        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers.entrySet()) {
//            if (currentWebDriver.getValue() != null) {
//                currentWebDriver.getValue().quit();
//            }
//        }
    }

    @BeforeMethod
    public void beforeMethod() {
    System.out.println("@BeforeMethod working.");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            System.out.println("***Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
//            takePageSource(takeScreenShot());
            }

    }

    public LoginPage loadAdminPage() {
//        getDriver().get(SERVER_ADMIN_URL); // multithread driver
        driver.get(SERVER_ADMIN_URL); // single thread driver
        return new LoginPage(driver); // single thread driver
//        return new LoginPage(getDriver()); // multithread driver
    }

    public HomePage loadMainPage() {
//        getDriver().get(SERVER_URL); // multithread driver
        driver.get(SERVER_URL); // single thread driver
        return new HomePage(driver); // single thread driver
//        return new HomePage(getDriver()); // multithread driver
    }

//    protected WebDriver getDriver() {
//        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
//        if (currentWebDriver == null) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("start-maximized");
//            currentWebDriver = new ChromeDriver();
//            currentWebDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//            drivers.put(Thread.currentThread().getId(), currentWebDriver);
//        }
//        return currentWebDriver;
//    }

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

//    private String takeScreenShot() throws IOException {
//        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
////        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
//        return "./img/" + currentTime + "_screenshot";
//    }

    private void takePageSource(String fileName) {
//        String pageSource = getDriver().getPageSource();
//        Path path = Paths.get(fileName + ".txt");
//        byte[] strToBytes = pageSource.getBytes();
//        try {
//            Files.write(path, strToBytes, StandardOpenOption.CREATE);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
