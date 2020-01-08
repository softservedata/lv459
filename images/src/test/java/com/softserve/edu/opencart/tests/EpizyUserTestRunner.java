package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.softserve.edu.opencart.pages.user.HomePage;

public abstract class EpizyUserTestRunner {
	private final Long ONE_SECOND_DELAY = 1000L;
	private final String SERVER_URL = "http://taqc-opencart.epizy.com";
	private static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				EpizyUserTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Before
	public void beforeMethod() {
		driver.get(SERVER_URL);
	}

	@After
	public void afterMethod() {
		// TODO Logout
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
