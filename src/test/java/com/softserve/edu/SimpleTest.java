package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleTest {

	@Test
	public void checkScroll() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://selenium.dev/downloads/");
		//
		WebElement linkProject = driver.findElement(By.cssSelector(".button-container a"));
		//
		// Scrolling by Action class
		Actions action = new Actions(driver);		
		action.moveToElement(linkProject).perform();
		//
		// Scrolling by JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkProject);
		//
		driver.quit();
	}
	
	 //@Test
	public void testLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("https://softserve.academy/");
		//
		// Goto login form
		driver.findElement(By.linkText("Log in")).click();
		//
		// Type username
//		driver.findElement(By.id("username")).click();
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("username")).sendKeys("my_name");
		//
		/*
		WebElement login = driver.findElement(By.id("username")); // Invalid solution
		login.click();
		login.clear();
		login.sendKeys("my_name");
		//
		// Refresh some webelements
		driver.navigate().refresh();
		//
		//login.click();
		login.clear();
		login.sendKeys("my_name_2");
		//
		*/
		//
		// Without local variable
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("my_name");
		//
		// Refresh some webelements
		driver.navigate().refresh();
		//
		// driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("my_name_2");
		//
		// Type password
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(System.getenv().get("MY_PASSWORD"));
		//
		driver.quit();
	}

	// @Test
	public void testWedDriver() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		System.out.println("***PATH: " + this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		// driver.navigate().to("http://www.google.com");
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!" + Keys.ENTER);
		System.out.println("1. Page title is: " + driver.getTitle());
		//element.sendKeys("Cheese!");
		//
		//element.submit();
		// System.out.println("1. Page title is: " + driver.getTitle());
		System.out.println("2. Page title is: " + driver.getTitle());
		//
		// driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("3. Page title is: " + driver.getTitle());
		//
		WebElement actual = driver.findElement(By.id("siteSub"));
		Assert.assertEquals("From Wikipedia, the free encyclopedia", actual.getText());
		//
		// driver.close();
		driver.quit();
	}

	// @Test
	public void testGoogle() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		// driver.navigate().to("http://www.google.com");
		//
		WebElement element = driver.findElement(By.name("q"));
		// element.sendKeys("Cheese!" + Keys.ENTER);
		System.out.println("1. Page title is: " + driver.getTitle());
		element.sendKeys("Cheese!");
		//
		element.submit();
		// System.out.println("1. Page title is: " + driver.getTitle());
		System.out.println("2. Page title is: " + driver.getTitle());
		//
		// driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("3. Page title is: " + driver.getTitle());
		//
		WebElement actual = driver.findElement(By.id("siteSub"));
		Assert.assertEquals("From Wikipedia, the free encyclopedia", actual.getText());
		//
		// driver.close();
		driver.quit();
	}

	// @Test
	public void testHanban() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		// driver.navigate().to("http://www.google.com");
		//
		WebElement element = driver.findElement(By.name("q"));
		// element.sendKeys("Cheese!" + Keys.ENTER);
		System.out.println("1. Page title is: " + driver.getTitle());
		element.sendKeys("hanban");
		//
		element.submit();
		// System.out.println("1. Page title is: " + driver.getTitle());
		System.out.println("2. Page title is: " + driver.getTitle());
		//
		// driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
		driver.findElement(By.partialLinkText("Confucius Institute Headquarters")).click();
		System.out.println("3. Page title is: " + driver.getTitle());
		//
		WebElement actual = driver.findElement(By.id("Hbhover"));
		Assert.assertEquals("WWW.HANBAN.ORG", actual.getText());
		//
		// driver.close();
		driver.quit();
	}

	// @Test
	public void testYahoo() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yahoo.com/");
		// driver.navigate().to("http://www.google.com");
		//
		WebElement element = driver.findElement(By.id("header-search-input"));
		// element.sendKeys("Cheese!" + Keys.ENTER);
		System.out.println("1. Page title is: " + driver.getTitle());
		element.sendKeys("hanban");
		//
		element.submit();
		// System.out.println("1. Page title is: " + driver.getTitle());
		System.out.println("2. Page title is: " + driver.getTitle());
		//
		// driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
		driver.findElement(By.partialLinkText("Hanban - Confucius Institute - College of Liberal Arts")).click();
		// driver.findElement(By.linkText("Hanban - Confucius Institute - College of
		// Liberal Arts and ...")).click();
		// driver.navigate().refresh();
		String currentTab = driver.getWindowHandle();
		System.out.println("currentTab: " + currentTab);
		for (String current : driver.getWindowHandles()) {
			System.out.println("TAB: " + current);
			if (!current.equals(currentTab)) {
				driver.switchTo().window(current);
				break;
			}
		}
		System.out.println("3. Page title is: " + driver.getTitle());
		//
		WebElement actual = driver.findElement(By.xpath("//li[contains(text(),'English ')]"));
		Assert.assertTrue(actual.getText().contains("http://english.hanban.org/"));
		//
		// driver.close();
		// driver.quit();
	}
	//@Test
	public void checkApp() {
		System.out.println("AppTest: checkApp()");
		Assert.assertTrue(true);
	}

	//@Test
	public void checkApp2() {
		System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
		System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
		Assert.assertTrue(true);
	}
}
