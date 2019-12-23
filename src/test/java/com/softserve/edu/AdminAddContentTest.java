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
	private final String POINT_ON_CATALOG_TAB = "//li[@id='menu-catalog']//i[contains(@class, 'fa fa-tags fw')]";
	private final String GET_CATEGORIES_TAB = "#menu-catalog > :nth-child(2) > :nth-child(1) > a";
	private final String ADD_NEW_ITEM = ".pull-right > .btn-primary";
	/*
	 * This test method adds items to Tablets tab.
	 */
	@Test
	public void addTablet() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_CATEGORIES_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(ADD_NEW_ITEM)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-name1")).click();
		driver.findElement(By.id("input-name1")).clear();
		driver.findElement(By.id("input-name1")).sendKeys("Tablets");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-meta-title1")).click();
		driver.findElement(By.id("input-meta-title1")).clear();
		driver.findElement(By.id("input-meta-title1")).sendKeys("Tablets");
		driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Tablets");
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();
	
	}
	
	/*
	 * This test method adds items to Software tab.
	 */
	@Test
	public void addSoftware() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_CATEGORIES_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(ADD_NEW_ITEM)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-name1")).click();
		driver.findElement(By.id("input-name1")).clear();
		driver.findElement(By.id("input-name1")).sendKeys("Software");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-meta-title1")).click();
		driver.findElement(By.id("input-meta-title1")).clear();
		driver.findElement(By.id("input-meta-title1")).sendKeys("Software");
		driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Software");
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();
	
	}
	
	/*
	 * This test method adds items to Phones & PDAs tab.
	 */
	@Test
	public void addSmartphone() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_CATEGORIES_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(ADD_NEW_ITEM)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-name1")).click();
		driver.findElement(By.id("input-name1")).clear();
		driver.findElement(By.id("input-name1")).sendKeys("Smartphones");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-meta-title1")).click();
		driver.findElement(By.id("input-meta-title1")).clear();
		driver.findElement(By.id("input-meta-title1")).sendKeys("Smartphones");
		driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Phones & PDAs");
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();
	
	}
	
	/*
	 * This test method adds items to Cameras tab.
	 */
	@Test
	public void addCamera() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_CATEGORIES_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(ADD_NEW_ITEM)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-name1")).click();
		driver.findElement(By.id("input-name1")).clear();
		driver.findElement(By.id("input-name1")).sendKeys("Cameras");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-meta-title1")).click();
		driver.findElement(By.id("input-meta-title1")).clear();
		driver.findElement(By.id("input-meta-title1")).sendKeys("Cameras");
		driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-parent")).click();
		driver.findElement(By.id("input-parent")).clear();
		driver.findElement(By.id("input-parent")).sendKeys("Cameras");
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector(".btn-primary > .fa")).click();
	
	}
}
