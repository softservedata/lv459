package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;

public abstract class LocalTestRunner {
	private final Long ONE_SECOND_DELAY = 1000L;
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    protected final String BLOCK_USER_ERROR_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
		    driver.findElement(By.id("logo")).click();
            loadApplication()
            .gotoMyAccount()
            .gotoEditAccountRight()
            .clickLogoutRight();
        }
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
