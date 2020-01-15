package com.softserve.edu.opencart.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.user.HomePage;

public abstract class EpizyUserTestRunner {
	private final Long ONE_SECOND_DELAY = 1000L;
	private String serverUrl = "http://taqc-opencart.epizy.com";
	private WebDriver driver;

	@BeforeClass
	public void beforeClass(ITestContext context) {
		System.setProperty("webdriver.chrome.driver",
				EpizyUserTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		// TODO Check Exist ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
			System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
			if (entry.getKey().toLowerCase().equals("url")) {
				serverUrl = entry.getValue();
				break;
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	//@Before
	@BeforeMethod
	public void beforeMethod() {
		driver.get(serverUrl);
	}

	//@After
	@AfterMethod
	public void afterMethod(ITestResult result) {
		// TODO Logout
		if (!result.isSuccess()) {
			System.out.println("***Test " + result.getName() + " ERROR");
			// Take Screenshot, save sourceCode, save to log, prepare report, Return to previous state, logout, etc.
		}
		// driver.get(SERVER_URL);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
