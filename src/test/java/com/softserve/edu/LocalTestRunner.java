package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class LocalTestRunner {
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		System.out.println("PATH: " + LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
		Thread.sleep(1000); // For Presentation Only
		driver.quit();
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\t@Before method");
		driver.get("http://192.168.43.135/opencart/upload/");
		Thread.sleep(1000); // For Presentation Only
		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}
	
	//@After
	public void tearDown() throws Exception {
		System.out.println("\t@After method");
		driver.findElement(By.cssSelector("#logo .img-responsive")).click();
	    Thread.sleep(1000); // For Presentation Only
	}
	
}
