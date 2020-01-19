package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import com.softserve.edu.opencart.pages.user.search.SearchCriteriaPart;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;

public abstract class LocalTestRunner {
	final int TWO_HUNDRED_AND_FIFTY_FIVE = 255;
	final int SIXTY_FIVE_THOUSANDS_FIVE_HUNDRED_AND_THIRTY_SIX = 65536;
	final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz\\*;.,%$#\\\\'{}()\",";
	private final Long ONE_SECOND_DELAY = 1000L;
    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
	//private final String SERVER_URL = "http://192.168.234.133/opencart/upload/";
    protected final String BLOCK_USER_ERROR_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
/*		System.setProperty("webdriver.chrome.driver",
				LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/


		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
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
            loadApplication()
            .gotoMyAccount()
            .gotoEditAccountRight()
            .clickLogoutRight();
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
