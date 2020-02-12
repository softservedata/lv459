package com.softserve.edu.opencart.tests.runner;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class LocalAdminSingleThreadRunner extends LocalAdminRunner {

    @BeforeClass
    public void beforeClass(ITestContext context) {

        // For single thread driver

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions ();
//        options.addArguments("start-maximized");
//        options.addArguments("--headless");
//        driver = new FirefoxDriver(options);
        //
        //
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //        options.addArguments("--no-sandbox");
        //        options.addArguments("--disable-gpu");
        //        options.addArguments("--disable-setuid-sandbox");
        //        options.addArguments("enable-automation");
        //        options.addArguments("--disable-extensions");
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

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            System.out.println("***Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report,
            takePageSource(takeScreenShot());
        }
    }

    private String takeScreenShot() throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // for single thread
        FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
        return "./img/" + currentTime + "_screenshot";
    }

    private void takePageSource(String fileName) {
        String pageSource = driver.getPageSource();
        Path path = Paths.get(fileName + ".txt");
        byte[] strToBytes = pageSource.getBytes();
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
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
