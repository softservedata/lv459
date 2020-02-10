package com.softserve.edu.opencart.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class LocalAdminMultiThreadRunner extends LocalAdminRunner {

    @BeforeClass
    public void beforeClass(ITestContext context) {

        // Multithread drivers
        //            for (Map.Entry<String, String> entry : context
        //            .getCurrentXmlTest().getAllParameters().entrySet()) {
        //                System.out.println("Key: " + entry.getKey() + "
        //                Value: " + entry.getValue());
        //                if (entry.getKey().toLowerCase().equals("url")) {
        //                    serverUrl = entry.getValue();
        //                    break;
        //                }
        //            }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        // closes driver if running in multi thread
        //        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers
        //        .entrySet()) {
        //            if (currentWebDriver.getValue() != null) {
        //                currentWebDriver.getValue().quit();
        //            }
        //        }
    }

    protected WebDriver getDriver() {
        WebDriver currentWebDriver = drivers.get(Thread.currentThread()
                                                         .getId());
        if (currentWebDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            currentWebDriver = new ChromeDriver();
            currentWebDriver.manage().timeouts().implicitlyWait(1,
                                                                TimeUnit.SECONDS);
            drivers.put(Thread.currentThread().getId(), currentWebDriver);
        }
        return currentWebDriver;
    }

    private String takeScreenShot() throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format
                (new Date());
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs
//                (OutputType.FILE); // for single thread
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs
                (OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./img/" + currentTime +
                                             "_screenshot.png"));
        return "./img/" + currentTime + "_screenshot";
    }

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
