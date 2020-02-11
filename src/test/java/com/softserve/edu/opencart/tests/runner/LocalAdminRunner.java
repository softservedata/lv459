package com.softserve.edu.opencart.tests.runner;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

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

}
