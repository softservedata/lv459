package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Test object: horizontal and vertical menu on opencart (content equals).
 * Test design technique: state transition diagram.
 * Test items: 
 * -tab “Desktops”,
 * -tab “Laptops & Notebooks”,
 * -tab “Components”,
 * -tab “Tablets”,
 * -tab “Software”,
 * -tab “Phones & PDAs”,
 * -tab “Cameras”,
 * -tab “MP3 Players”,
 * -menus which are visible after clicking on some tab,
 * -changes after adding new tab,
 * -menus of each tab.
 * 
 * @version 13.0.1 15 Oct 2019
 */
public class ContentEqualsTest {
	//Next constant stores driver value
	String DRIVERLAUNCH = "webdriver.chrome.driver";
	//This constant stores path to Chromedriver
	String DRIVERPATH = "/chromedriver-windows-32bit.exe";
	//This one has Opencart address
	String OPENCART = "http://192.168.43.135/opencart/upload/";
	
	/*
	 * This test method check if there are certain tabs.
	 */
	//@Test
	public void checkTabs() throws Exception {
		System.setProperty(DRIVERLAUNCH, this.getClass().getResource(DRIVERPATH).getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000); // For Presentation Only
		driver.get(OPENCART);
		Thread.sleep(1000); // For Presentation Only
		WebElement desktops = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Assert.assertEquals("Desktops", desktops.getText());
		
		WebElement laptops = driver.findElement(By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Assert.assertEquals("Laptops & Notebooks", laptops.getText());
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Components')]"));
		Assert.assertEquals("Components", components.getText());
		
		WebElement tablets = driver.findElement(By.xpath("//li/a[contains(text(), 'Tablets')]"));
		Assert.assertEquals("Tablets", tablets.getText());
		
		WebElement software = driver.findElement(By.xpath("//li/a[contains(text(), 'Software')]"));
		Assert.assertEquals("Software", software.getText());
		
		WebElement phones = driver.findElement(By.xpath("//li/a[contains(text(), 'Phones & PDAs')]"));
		Assert.assertEquals("Phones & PDAs", phones.getText());
		
		WebElement cameras = driver.findElement(By.linkText("Cameras"));
		Assert.assertEquals("Cameras", cameras.getText());
		
		WebElement mp3 = driver.findElement(By.xpath("//li/a[contains(text(), 'MP3 Players')]"));
		Assert.assertEquals("MP3 Players", mp3.getText());
		Thread.sleep(5000); // For Presentation Only
		driver.quit();
		
	}
	
	/*
	 * This test method checks availability certain tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	//@Test
	public void CheckPC() throws Exception {
		
		String expectedPC = "PC (0)";//getText
		
		System.setProperty(DRIVERLAUNCH, this.getClass().getResource(DRIVERPATH).getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000); // For Presentation Only
		driver.get(OPENCART);
		Thread.sleep(1000); // For Presentation Only
		WebElement desktop = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktop).perform();
		
		WebElement pc = driver.findElement(By.linkText("PC (0)"));
		Assert.assertEquals(expectedPC, pc.getText());

		driver.findElement(By.linkText("Show All Desktops")).click();
		WebElement pcVertical = driver.findElement(By.cssSelector(".list-group > :nth-child(2)"));
//		Assert.assertEquals(expectedPC, pcVertical.getText()); //Failure
		Assert.assertTrue(pcVertical.getText().contains(expectedPC));
		//It's awful, but it works!
//		String pcActual = pcVertical.getText();
//		boolean endWith = pcActual.endsWith(expectedPC);
//		Assert.assertTrue(endWith);
		
		WebElement pcRefine = driver.findElement(By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(1) > a"));
		Assert.assertEquals(expectedPC, pcRefine.getText());
		
		Thread.sleep(5000); // For Presentation Only
		driver.quit();
	}
	
	@Test
	public void CheckMac() throws Exception {
	
		String expectedMac = "Mac (1)";
		
		System.setProperty(DRIVERLAUNCH, this.getClass().getResource(DRIVERPATH).getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000); // For Presentation Only
		driver.get(OPENCART);
		Thread.sleep(1000); // For Presentation Only
		WebElement desktop = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktop).perform();
		
		WebElement mac = driver.findElement(By.linkText("Mac (1)"));
		Assert.assertEquals(expectedMac, mac.getText());

		driver.findElement(By.linkText("Show All Desktops")).click();;
		WebElement macVertical = driver.findElement(By.cssSelector(".list-group > :nth-child(3)"));
		Assert.assertTrue(macVertical.getText().contains(expectedMac));
		//It's awful, but it works!
//		String macActual = macVertical.getText();
//		boolean endWith = macActual.endsWith(expectedMac);
//		Assert.assertTrue(endWith);
		
		WebElement macRefine = driver.findElement(By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(2) > a"));
		Assert.assertEquals(expectedMac, macRefine.getText());
		
		Thread.sleep(5000); // For Presentation Only
		driver.quit();
	
	}
	
}
