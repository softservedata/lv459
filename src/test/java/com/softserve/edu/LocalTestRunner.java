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
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
				//"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		System.out.println("PATH: " + LocalTestRunner.class.getResource(
				"/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.43.135/opencart/upload/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("@AfterClass");
		driver.quit();
	}
	
	@Before
	public void setUp() {
		System.out.println("\t@Before method");
	}
	
	@After
	public void tearDown() {
		System.out.println("\t@After method");
		driver.findElement(By.id("logo")).click();
	}
	
}
