package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("AllureTest")
@Feature("Login_Application_Test FEATURE")
public class AppTestReport {
	public static final Logger logger = LoggerFactory.getLogger(AppTestReport.class);
	private WebDriver driver; 

	@Attachment(value = "{0}", type = "image/png")
	public byte[] saveImageAttach(String attachName) {
		byte[] result = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			result = Files.readAllBytes(scrFile.toPath());
			FileUtils.copyFile(scrFile, new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.png"));
		} catch (IOException e) {
			// TODO Create Custom Exception 
			e.printStackTrace();
		}
		return result;
	}

	@Attachment(value = "{0}", type = "text/plain")
	public byte[] saveHtmlAttach(String attachName) {
		return driver.getPageSource().getBytes();
	}

	
	@Attachment(value = "{0}", type = "text/plain")
	public byte[] saveTextAttach(String attachName, String attachPath) {
		byte[] result = null;
		try {
			result = Files.readAllBytes(Paths.get(attachPath));
		} catch (IOException e) {
			// TODO Create Custom Exception 
			e.printStackTrace();
		}
		return result;
	}

	@Step("goto_Login STEP")
	private void takeScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.png"));
		String htmlText = driver.getPageSource();
		//FileUtils.writeStringToFile(new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.html"), htmlText);
		Path path = Paths.get(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.html");
		Files.write(path, htmlText.getBytes(), StandardOpenOption.CREATE);
	}
	
	// @Test
	public void testApp1() throws Exception {
		System.out.println("surefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
		System.out.println("selenium.version = " + System.getProperty("selenium.version"));
		System.out.println("database.password = " + System.getProperty("database.password"));
		System.out.println("System.getenv().database.password = " + System.getenv().get("DATABASE_PASSWORD"));
		//
		// System.out.println("System.getenv() = " + System.getenv());
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("AppTestReport @Before setUp()");
	}

	@AfterMethod
	//public void tearDown() throws Exception {
	public void tearDown(ITestResult result) throws Exception {
		// Add Reporter.log from @AfterMethod to REPORT 
		Reporter.setCurrentTestResult(result);
		System.out.println("@After tearDown()");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>", 7, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 9</FONT><BR>", 9, true);
		if (!result.isSuccess()) {
		//if (true) {
			Reporter.log("<BR><BR><FONT SIZE='4' COLOR='RED'>ALARM TEST FAIL "
					+ result.getName() 
					+ "</FONT><BR>", true);
			Reporter.log("<br><p>Screenshot</p>");
			takeScreenShot();
//			Reporter.log("<br><p><a href='d:\\screenshot.png'>Source Code</a> filename is d:\\Screenshot.png</p>");	
			Reporter.log("<br><div><image style=\"max-width:80%%\" src=\""
			+ System.getenv().get("USERPROFILE")
			+ "\\Downloads\\Screenshot.png\"  alt=\"could not take screen shot\" /></div>");
			// Add Screenshot, etc.
		}
	}

	@BeforeClass
	public void beforeClass(ITestContext context) {
		logger.info("@BeforeClass for " + this.getClass().getName());
		System.out.println("@BeforeClass");
	    System.setProperty("webdriver.chrome.driver",
	    		this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
	    driver = new ChromeDriver();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		logger.info("@AfterClass for " + this.getClass().getName());
		driver.quit();
	}

	@Description("Test Description: class AllureTest; testAllure1().")
	@Severity(SeverityLevel.BLOCKER)
	@Story("testApp2 STORY")
	@Issue("LVATQAOMS-776")
	@Link("https://softserve.academy/")
	@Test
	public void testApp2() {
		logger.info("\t+++testApp2() Start");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Only Report.</FONT><BR>");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 2 FATAL</FONT><BR>", 2, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3 ERROR</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5 WARNING</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7 INFO</FONT><BR>", 7, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 9 TRACE</FONT><BR>", 9, true);
		System.out.println("Running . . .");
		Assert.assertTrue(true);
		logger.info("\t+++testApp2() DONE");
	}

//	@Severity(SeverityLevel.NORMAL)
//	@Story("check_Product_Currency STORY")
	@Test
	public void testApp3() {
		logger.info("\t+++testApp3() Start");
		Reporter.log("\t+++testApp3() must be", true);
		Reporter.log("\t+++testApp3() 3", 3, true);
		Reporter.log("\t+++testApp3() 5", 5, true);
		Reporter.log("\t+++testApp3() 7", 7, true);
		Reporter.log("\t+++testApp3() 9", 9, true);
		//
		logger.info("\t+++testApp3() DONE");
		System.out.println("\t+++testApp3() DONE");
	}
	
	@Test
	public void testChrome1() throws Exception {
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/");
        Thread.sleep(2000); // Do no use
        //
        // Move to Element by JavaScript Injection
        WebElement position = driver.findElement(By.id("use-paging-with-other-data-processing-plugins"));
        // WebElement position =
        // driver.findElement(By.cssSelector("#using-paging-with-other-data-processing-plugins"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", position);
        takeScreenShot();
        //
        saveImageAttach("devextreme-reactive");
        //saveTextAttach("<br>html Info", System.getenv().get("USERPROFILE") + "/Downloads/Screenshot.html");
        saveHtmlAttach("HTML Source of devextreme-reactive");
        saveTextAttach("<br>html Info: React_Grid", System.getenv().get("USERPROFILE") + "/Downloads/React_Grid.html");
        Assert.assertTrue(false);
	}
	
}
