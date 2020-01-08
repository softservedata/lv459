package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public final class FindTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
//		System.setProperty("webdriver.chrome.driver",
//		"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				FindTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		System.out.println("PATH: " + FindTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());
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
		driver.get("http://10.26.34.200/opencart/upload/");
		Thread.sleep(1000); // For Presentation Only
		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\t@After method");
	}

	private WebElement getElementByName(String name) {
		WebElement result = null;
		List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
		for (WebElement current : containers) {
			if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
				result = current;
				break;
			}
		}
		if (result == null) {
			// Develop Custom Exception
			throw new RuntimeException("WebElement by title/name: " + name + " not found");
		}
		return result;
	}

	// @Test
	public void findByCss() throws Exception {
		// Precondition
		// Choose Curency
		driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector("[name='USD']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// driver.findElement(By.cssSelector("a:contains('MacBook')")).click(); // ERROR
		// Search a $("div.product-layout.product-grid h4 > a")
		// Search h4 $("div.product-layout.product-grid h4:has(> a)")
		// Search Price $("div.product-layout.product-grid h4:has(> a[href*='id=43']) +p + p")
		// Search Price $("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p[class='price']")
		//
		// Check
		// WebElement price =
		// driver.findElement(By.cssSelector("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p.price")); // id=43 Hardcode Invalid Solution
		WebElement price = getElementByName("MacBook").findElement(By.cssSelector("p.price"));
		Assert.assertTrue(price.getText().contains("$602.00"));
		//
		// Return to Previous State
		driver.findElement(By.cssSelector("#logo .img-responsive")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	// @Test
	public void loginByCss() throws Exception {
		// Precondition
		// Click My Account Button
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click login Button
		driver.findElement(By.cssSelector("#top-links a[href*='account/login']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Login Email
		driver.findElement(By.cssSelector("#input-email")).click();
		driver.findElement(By.cssSelector("#input-email")).clear();
		driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Password
		//driver.findElement(By.id("input-password")).click();
		driver.findElement(By.cssSelector("#input-password")).click();
		driver.findElement(By.cssSelector("#input-password")).clear();
		driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Login Button
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Goto Edit Account
		driver.findElement(By.cssSelector("#column-right a[href*='account/edit']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Read Email WebElement
		//WebElement price = driver.findElement(By.id("input-email"));
		WebElement email = driver.findElement(By.cssSelector("#input-email"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		Assert.assertEquals("hahaha@gmail.com", email.getAttribute("value"));
		//
		// Return to Previous State
		// Click My Account Button
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Logout Button
		driver.findElement(By.cssSelector("#top-links a[href*='account/logout']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Continue Button
		driver.findElement(By.cssSelector("#content a[href*='common/home']")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	//@Test
	public void findByXPath() throws Exception {
		// Precondition
		// Choose Curency
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//button[@name='EUR']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Search Field
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Search Button
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("472.33"));
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	@Test
	public void loginByXPath() throws Exception {
		// Precondition
		// Click My Account Button
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click login Button
		driver.findElement(By.xpath("//a[contains(@href, 'account/login')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Login Email
		driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hahaha@gmail.com");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Password
		//driver.findElement(By.id("input-password")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Login Button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Goto Edit Account
		driver.findElement(By.xpath("//aside//a[contains(@href, 'account/edit')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Read Email WebElement
		//WebElement price = driver.findElement(By.id("input-email"));
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		Assert.assertEquals("hahaha@gmail.com", email.getAttribute("value"));
		//
		// Return to Previous State
		// Click My Account Button
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Logout Button
		driver.findElement(By.xpath("//a[contains(@href, 'account/logout')]")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Continue Button
		driver.findElement(By.xpath("//div[@id='content']//a[contains(@href, 'common/home')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

}
