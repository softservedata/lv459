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
	public void CheckPC() throws Exception {
		
		String expectedPC = "PC (0)";
		
		WebElement desktops = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktops).perform();
		
		//WebElement pc = driver.findElement(By.linkText("PC (0)"));
		WebElement pc = driver.findElement(By.cssSelector("#menu a[href*='20_26']"));
		Assert.assertEquals(expectedPC, pc.getText());

		driver.findElement(By.cssSelector(":nth-child(1) > .dropdown-menu > .see-all")).click();
		WebElement pcVertical = driver.findElement(By.xpath("//div/a[contains(@href,'20_26')]"));
		Assert.assertTrue(pcVertical.getText().contains(expectedPC));
		
		WebElement pcRefine = driver.findElement(
				By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(1) > a"));
		Assert.assertEquals(expectedPC, pcRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Mac items on Desktops tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckMac() throws Exception {
	
		String expectedMac = "Mac (1)";
		
		WebElement desktop = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(desktop).perform();
		
		//WebElement mac = driver.findElement(By.linkText("Mac (1)"));
		WebElement mac = driver.findElement(By.cssSelector("#menu a[href*='20_27']"));
		Assert.assertEquals(expectedMac, mac.getText());

		driver.findElement(By.cssSelector(":nth-child(1) > .dropdown-menu > .see-all")).click();
		WebElement macVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '20_27')]"));
		Assert.assertTrue(macVertical.getText().contains(expectedMac));
		
		WebElement macRefine = driver.findElement(
				By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(2) > a"));
		Assert.assertEquals(expectedMac, macRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	
	}
	
	/*
	 * This test method checks availability Macs items on Laptops & Notebooks tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckMacs() throws Exception {
		
		String expectedMacs = "Macs (0)";
		
		WebElement laptops = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(laptops).perform();
		
		WebElement macs = driver.findElement(By.cssSelector("#menu a[href*='18_46']"));
		Assert.assertEquals(expectedMacs, macs.getText());

		driver.findElement(By.cssSelector(":nth-child(2) > .dropdown-menu > .see-all")).click();
		WebElement macsVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '18_46')]"));
		Assert.assertTrue(macsVertical.getText().contains(expectedMacs));
		
		WebElement macsRefine = driver.findElement(
				By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(1) > a"));
		Assert.assertEquals(expectedMacs, macsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Windows items on Laptops & Notebooks tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckWindows() throws Exception {
		
		String expectedWindows = "Windows (0)";
		
		WebElement laptops = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(laptops).perform();
		
		WebElement windows = driver.findElement(By.cssSelector("#menu a[href*='18_45']"));
		Assert.assertEquals(expectedWindows, windows.getText());

		driver.findElement(By.cssSelector(":nth-child(2) > .dropdown-menu > .see-all")).click();
		WebElement windowsVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '18_45')]"));
		Assert.assertTrue(windowsVertical.getText().contains(expectedWindows));
		
		WebElement windowsRefine = driver.findElement(By.cssSelector(":nth-child(5) > .col-sm-3 > ul > :nth-child(2) > a"));
		Assert.assertEquals(expectedWindows, windowsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Mice items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckMice() throws Exception {
		
		String expectedMice = "Mice and Trackballs (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement mice = driver.findElement(By.cssSelector("#menu a[href*='25_29']"));
		Assert.assertEquals(expectedMice, mice.getText());

		driver.findElement(By.cssSelector(":nth-child(3) > .dropdown-menu > .see-all")).click();
		WebElement miceVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '25_29')]"));
		Assert.assertTrue(miceVertical.getText().contains(expectedMice));
		
		WebElement miceRefine = driver.findElement(
				By.cssSelector("#content > .row > .col-sm-3 > ul > :nth-child(1) > a"));
		Assert.assertEquals(expectedMice, miceRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Monitors items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckMonitors() throws Exception {
		
		String expectedMonitors = "Monitors (2)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement monitors = driver.findElement(By.cssSelector("#menu a[href*='25_28']"));
		Assert.assertEquals(expectedMonitors, monitors.getText());

		driver.findElement(By.cssSelector(":nth-child(3) > .dropdown-menu > .see-all")).click();
		WebElement monitorsVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '25_28')]"));
		Assert.assertTrue(monitorsVertical.getText().contains(expectedMonitors));
		
		WebElement monitorRefine = driver.findElement(
				By.cssSelector("#content > .row > .col-sm-3 > ul > :nth-child(2) > a"));
		Assert.assertEquals(expectedMonitors, monitorRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Printers items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckPrinters() throws Exception {
		
		String expectedPrinters = "Printers (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement printers = driver.findElement(By.cssSelector("#menu a[href*='25_30']"));
		Assert.assertEquals(expectedPrinters, printers.getText());

		driver.findElement(By.cssSelector(":nth-child(3) > .dropdown-menu > .see-all")).click();
		WebElement printersVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '25_30')]"));
		Assert.assertTrue(printersVertical.getText().contains(expectedPrinters));
		
		WebElement printersRefine = driver.findElement(
				By.cssSelector("#content > .row > .col-sm-3 > ul > :nth-child(3) > a"));
		Assert.assertEquals(expectedPrinters, printersRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Scanners items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckScanners() throws Exception {
		
		String expectedScanners = "Scanners (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement scanners = driver.findElement(By.cssSelector("#menu a[href*='25_31']"));
		Assert.assertEquals(expectedScanners, scanners.getText());

		driver.findElement(By.cssSelector(":nth-child(3) > .dropdown-menu > .see-all")).click();
		WebElement scannersVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '25_31')]"));
		Assert.assertTrue(scannersVertical.getText().contains(expectedScanners));
		
		WebElement scannerRefine = driver.findElement(
				By.cssSelector("#content > .row > .col-sm-3 > ul > :nth-child(4) > a"));
		Assert.assertEquals(expectedScanners, scannerRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Web Cameras items on Components tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckWebCams() throws Exception {
		
		String expectedWebCams = "Web Cameras (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Components')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement webcams = driver.findElement(By.cssSelector("#menu a[href*='25_32']"));
		Assert.assertEquals(expectedWebCams, webcams.getText());

		driver.findElement(By.cssSelector(":nth-child(3) > .dropdown-menu > .see-all")).click();
		WebElement webcamsVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '25_32')]"));
		Assert.assertTrue(webcamsVertical.getText().contains(expectedWebCams));
		
		WebElement webcamsRefine = driver.findElement(
				By.cssSelector(".col-sm-3 > ul > :nth-child(5) > a"));
		Assert.assertEquals(expectedWebCams, webcamsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Tablets items on Tablets tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckTablets() throws Exception {
		
		String expectedTablets = "Tablets (1)";
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Tablets')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement tablets = driver.findElement(By.cssSelector("#menu a[href*='57_75']"));
		Assert.assertEquals(expectedTablets, tablets.getText());

		driver.findElement(By.cssSelector(":nth-child(4) > .dropdown-menu > .see-all")).click();
		WebElement tabletsVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '57_75')]"));
		Assert.assertTrue(tabletsVertical.getText().contains(expectedTablets));
		
		WebElement tabletsRefine = driver.findElement(
				By.xpath("//div[@id='content']//li/a[contains(@href,'path=57_75')]"));
		Assert.assertEquals(expectedTablets, tabletsRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Software items on Software tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckSoftware() throws Exception {
		
		String expectedSoftware = "Software (0)";
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Software')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement software = driver.findElement(By.cssSelector("#menu a[href*='17_76']"));
		Assert.assertEquals(expectedSoftware, software.getText());

		driver.findElement(By.cssSelector(":nth-child(5) > .dropdown-menu > .see-all")).click();
		WebElement softwareVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '17_76')]"));
		Assert.assertTrue(softwareVertical.getText().contains(expectedSoftware));
		
		WebElement softwareRefine = driver.findElement(
				By.xpath("//div[@id='content']//li/a[contains(@href,'path=17_76')]"));
		Assert.assertEquals(expectedSoftware, softwareRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Smartphones items on Phones & PDAs tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckSmartphones() throws Exception {
		
		String expectedSmartphones = "Smartphones (3)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Phones & PDAs')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement smartphones = driver.findElement(By.cssSelector("#menu a[href*='24_73']"));
		Assert.assertEquals(expectedSmartphones, smartphones.getText());

		driver.findElement(By.cssSelector(":nth-child(6) > .dropdown-menu > .see-all")).click();
		WebElement smartphonesVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '24_73')]"));
		Assert.assertTrue(smartphonesVertical.getText().contains(expectedSmartphones));
		
		WebElement smartphonesRefine = driver.findElement(
				By.xpath("//div[@id='content']//li/a[contains(@href,'path=24_73')]"));
		Assert.assertEquals(expectedSmartphones, smartphonesRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability Cameras items on Cameras tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckCameras() throws Exception {
		
		String expectedCameras = "Cameras (2)";
		
		WebElement components = driver.findElement(By.cssSelector(":nth-child(7) > a"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement cameras = driver.findElement(By.cssSelector("#menu a[href*='33_74']"));
		Assert.assertEquals(expectedCameras, cameras.getText());

		driver.findElement(
				By.xpath("//div[@class='dropdown-menu']//a[contains(text(),'Show All Cameras')]"))
				.click();
		WebElement camerasVertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '33_74')]"));
		Assert.assertTrue(camerasVertical.getText().contains(expectedCameras));
		
		WebElement camerasRefine = driver.findElement(
				By.xpath("//div[@id='content']//li/a[contains(@href,'path=33_74')]"));
		Assert.assertEquals(expectedCameras, camerasRefine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
	
	/*
	 * This test method checks availability MP3 Players items on MP3 Players tab
	 * on horizontal menu such as on vertical and “Refine Search” menus.
	 */
	@Test
	public void CheckMP3() throws Exception {
		
		String expectedMP3 = "MP3 Players (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'MP3 Players')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement mp3 = driver.findElement(By.cssSelector("#menu a[href*='34_78']"));
		Assert.assertEquals(expectedMP3, mp3.getText());

		driver.findElement(By.cssSelector(":nth-child(8) > .dropdown-menu > .see-all")).click();
		WebElement mp3Vertical = driver.findElement(
				By.xpath("//aside[@id='column-left']//a[contains(@href, '34_78')]"));
		Assert.assertTrue(mp3Vertical.getText().contains(expectedMP3));
		
		WebElement mp3Refine = driver.findElement(
				By.xpath("//div[@id='content']//li/a[contains(@href,'path=34_78')]"));
		Assert.assertEquals(expectedMP3, mp3Refine.getText());
		Thread.sleep(2000); // For Presentation Only
	}
}
