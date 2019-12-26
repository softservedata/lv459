package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Test object: horizontal and vertical menu on Opencart (content equals).
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
public class ContentEqualsTest extends LocalTestRunner {
	/*
	 * This test method checks availability PC items on Desktops tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkPC() throws Exception {
		
		String expectedPC = "PC (0)";
		
		WebElement desktops = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktops).perform();
		
		WebElement pc = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'PC (0)')]"));
		Assert.assertEquals(expectedPC, pc.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Desktops')]")).click();
		WebElement pcVertical = driver.findElement(
				By.xpath("//div[@class='list-group']/a[contains(text(),'PC (0)')]"));
		Assert.assertTrue(pcVertical.getText().contains(expectedPC));
		
		WebElement pcRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'PC (0)')]"));
		Assert.assertEquals(expectedPC, pcRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Mac items on Desktops tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkMac() throws Exception {
	
		String expectedMac = "Mac (1)";
		
		WebElement desktop = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktop).perform();
		
		WebElement mac = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Mac (1)')]"));
		Assert.assertEquals(expectedMac, mac.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Desktops')]")).click();
		WebElement macVertical = driver.findElement(
				By.xpath("//div[@class='list-group']/a[contains(text(),'Mac (1)')]"));
		Assert.assertTrue(macVertical.getText().contains(expectedMac));
		
		WebElement macRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Mac (1)')]"));
		Assert.assertEquals(expectedMac, macRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	
	}
	
	/*
	 * This test method checks availability Macs items on Laptops & Notebooks tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkMacs() throws Exception {
		
		String expectedMacs = "Macs (0)";
		
		WebElement laptops = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(laptops).perform();
		
		WebElement macs = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Macs (0)')]"));
		Assert.assertEquals(expectedMacs, macs.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Laptops & Notebooks')]"))
				.click();
		WebElement macsVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Macs (0)')]"));
		Assert.assertTrue(macsVertical.getText().contains(expectedMacs));
		
		WebElement macsRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Macs (0)')]"));
		Assert.assertEquals(expectedMacs, macsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Windows items on Laptops & Notebooks tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkWindows() throws Exception {
		
		String expectedWindows = "Windows (0)";
		
		WebElement laptops = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(laptops).perform();
		
		WebElement windows = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Windows (0)')]"));
		Assert.assertEquals(expectedWindows, windows.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Laptops & Notebooks')]"))
				.click();
		WebElement windowsVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Windows (0)')]"));
		Assert.assertTrue(windowsVertical.getText().contains(expectedWindows));
		
		WebElement windowsRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Windows (0)')]"));
		Assert.assertEquals(expectedWindows, windowsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Mice items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkMice() throws Exception {
		
		String expectedMice = "Mice and Trackballs (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement mice = driver.findElement(By.xpath
				("//div[@class='dropdown-menu']//a[contains(text(),'Mice and Trackballs (0)')]"));
		Assert.assertEquals(expectedMice, mice.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Components')]")).click();
		WebElement miceVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Mice and Trackballs (0)')]"));
		Assert.assertTrue(miceVertical.getText().contains(expectedMice));
		
		WebElement miceRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Mice and Trackballs (0)')]"));
		Assert.assertEquals(expectedMice, miceRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Monitors items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkMonitors() throws Exception {
		
		String expectedMonitors = "Monitors (2)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement monitors = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Monitors (2)')]"));
		Assert.assertEquals(expectedMonitors, monitors.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Components')]")).click();
		WebElement monitorsVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Monitors (2)')]"));
		Assert.assertTrue(monitorsVertical.getText().contains(expectedMonitors));
		
		WebElement monitorRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Monitors (2)')]"));
		Assert.assertEquals(expectedMonitors, monitorRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Printers items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkPrinters() throws Exception {
		
		String expectedPrinters = "Printers (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement printers = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Printers (0)')]"));
		Assert.assertEquals(expectedPrinters, printers.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Components')]")).click();
		WebElement printersVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Printers (0)')]"));
		Assert.assertTrue(printersVertical.getText().contains(expectedPrinters));
		
		WebElement printersRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Printers (0)')]"));
		Assert.assertEquals(expectedPrinters, printersRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Scanners items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkScanners() throws Exception {
		
		String expectedScanners = "Scanners (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement scanners = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Scanners (0)')]"));
		Assert.assertEquals(expectedScanners, scanners.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Components')]")).click();
		WebElement scannersVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Scanners (0)')]"));
		Assert.assertTrue(scannersVertical.getText().contains(expectedScanners));
		
		WebElement scannerRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Scanners (0)')]"));
		Assert.assertEquals(expectedScanners, scannerRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Web Cameras items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkWebCams() throws Exception {
		
		String expectedWebCams = "Web Cameras (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement webcams = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Web Cameras (0)')]"));
		Assert.assertEquals(expectedWebCams, webcams.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Components')]")).click();
		WebElement webcamsVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Web Cameras (0)')]"));
		Assert.assertTrue(webcamsVertical.getText().contains(expectedWebCams));
		
		WebElement webcamsRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Web Cameras (0)')]"));
		Assert.assertEquals(expectedWebCams, webcamsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Tablets items on Tablets tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkTablets() throws Exception {
		
		String expectedTablets = "Tablets (1)";
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Tablets')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement tablets = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Tablets (1)')]"));
		Assert.assertEquals(expectedTablets, tablets.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Tablets')]")).click();
		WebElement tabletsVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Tablets (1)')]"));
		Assert.assertTrue(tabletsVertical.getText().contains(expectedTablets));
		
		WebElement tabletsRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Tablets (1)')]"));
		Assert.assertEquals(expectedTablets, tabletsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Software items on Software tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkSoftware() throws Exception {
		
		String expectedSoftware = "Software (0)";
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Software')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement software = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Software (0)')]"));
		Assert.assertEquals(expectedSoftware, software.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[text()='Show All Software']")).click();
		WebElement softwareVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Software (0)')]"));
		Assert.assertTrue(softwareVertical.getText().contains(expectedSoftware));
		
		WebElement softwareRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Software (0)')]"));
		Assert.assertEquals(expectedSoftware, softwareRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Smartphones items on Phones & PDAs tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkSmartphones() throws Exception {
		
		String expectedSmartphones = "Smartphones (3)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Phones & PDAs')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement smartphones = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Smartphones (3)')]"));
		Assert.assertEquals(expectedSmartphones, smartphones.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[contains(text(),'Show All Phones & PDAs')]")).click();
		WebElement smartphonesVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Smartphones (3)')]"));
		Assert.assertTrue(smartphonesVertical.getText().contains(expectedSmartphones));
		
		WebElement smartphonesRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Smartphones (3)')]"));
		Assert.assertEquals(expectedSmartphones, smartphonesRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Cameras items on Cameras tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkCameras() throws Exception {
		
		String expectedCameras = "Cameras (2)";
		
		WebElement components = driver.findElement(
				By.xpath("//li[@class='dropdown']/a[contains(text(),'Cameras')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement cameras = driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[text()='Cameras (2)']"));
		Assert.assertEquals(expectedCameras, cameras.getText());

		driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Show All Cameras')]"))
				.click();
		WebElement camerasVertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'Cameras (2)')]"));
		Assert.assertTrue(camerasVertical.getText().contains(expectedCameras));
		
		WebElement camerasRefine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'Cameras (2)')]"));
		Assert.assertEquals(expectedCameras, camerasRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability MP3 Players items on MP3 Players tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void checkMP3() throws Exception {
		
		String expectedMP3 = "MP3 Players (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'MP3 Players')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement mp3 = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'MP3 Players (0)')]"));
		Assert.assertEquals(expectedMP3, mp3.getText());

		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu']//a[text()='Show All MP3 Players']")).click();
		WebElement mp3Vertical = driver.findElement(
				By.xpath("//div[@class='list-group']//a[contains(text(),'MP3 Players (0)')]"));
		Assert.assertTrue(mp3Vertical.getText().contains(expectedMP3));
		
		WebElement mp3Refine = driver.findElement(
				By.xpath("//div[@class='col-sm-3']//a[contains(text(),'MP3 Players (0)')]"));
		Assert.assertEquals(expectedMP3, mp3Refine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
}
