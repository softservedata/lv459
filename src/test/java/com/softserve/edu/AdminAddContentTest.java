package com.softserve.edu;

import org.junit.Test;
import org.openqa.selenium.By;

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
public class AdminAddContentTest extends AdminTestRunner {
	/*
	 * This test method adds
	 */
	@Test
	public void addTablets() throws Exception {
		driver.findElement(By.id("input-name1")).click();
		driver.findElement(By.id("input-name1")).clear();
		driver.findElement(By.id("input-name1")).sendKeys("Tab");
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.id("input-meta-title1")).click();
		driver.findElement(By.id("input-meta-title1")).clear();
		driver.findElement(By.id("input-meta-title1")).sendKeys("Tab");
		driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Tablets");
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Tablets");
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();

		
	}
	
}
