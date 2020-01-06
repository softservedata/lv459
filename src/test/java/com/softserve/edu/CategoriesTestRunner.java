package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class CategoriesTestRunner {
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver", 
				LocalTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		System.out.println("PATH: " + LocalTestRunner.class.getResource(
				"/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.43.135//opencart/upload/admin/");
		driver.findElement(By.id("input-username")).click();
		driver.findElement(By.id("input-username")).clear();
		driver.findElement(By.id("input-username")).sendKeys(System.getenv().get("OPENCART_LOGIN"));
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("OPENCART_PASSWORD"));
		driver.findElement(By.className("btn")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("@AfterClass");
		driver.findElement(By.className("hidden-xs")).click();
		driver.quit();
	}
	
	@Before
	public void setUp() {
		System.out.println("\t@Before method");
		driver.findElement(By.xpath("//i[contains(@class, 'fa fa-tags fw')]")).click();
		driver.findElement(
				By.xpath("//li[@id='menu-catalog']//a[contains(text(),'Categories')]")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
	}
	
	@After
	public void tearDown() {
		System.out.println("\t@After method");
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();
	}
}
