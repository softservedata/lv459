package com.softserve.edu.rest.test;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.rest.services.GuestService;

import io.qameta.allure.Step;

public abstract class RestTestRunner {
	private final Long ONE_SECOND_DELAY = 1000L;

	@BeforeClass
	public void beforeClass(ITestContext context) {
		for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
			System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
		}
	}

//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//	}

	// @Before
	@BeforeMethod
	public void beforeMethod() {
	}

	// @After
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		// TODO Logout
		loadApplication().resetServiceToInitialState();
		if (!result.isSuccess()) {
			System.out.println("***Test " + result.getName() + " ERROR");
		}
	}

	@Step("Load_Application")
	public GuestService loadApplication() {
		// TODO Check Server Availability
		return new GuestService();
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
